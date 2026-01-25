package net.novarayx.toanotherdimension.worldgen.portal;

import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.util.ITeleporter;
import net.novarayx.toanotherdimension.block.ModBlocks;
import net.novarayx.toanotherdimension.block.custom.ModPortalBlock;
import net.novarayx.toanotherdimension.worldgen.dimension.ModDimensions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class ModTeleporter implements ITeleporter {

    @Override
    public Entity placeEntity(
            Entity entity,
            ServerLevel currentLevel,
            ServerLevel destinationLevel,
            float yaw,
            Function<Boolean, Entity> repositionEntity
    ) {
        // Let vanilla create the entity in the destination
        Entity newEntity = repositionEntity.apply(false);

        /* ===============================
           RETURNING TO OVERWORLD
           =============================== */
        if (destinationLevel.dimension() != ModDimensions.NOVARAYDIM_LEVEL_KEY) {
            BlockPos surfacePos = findSurface(destinationLevel, new BlockPos((int)newEntity.getX(), 0, (int)newEntity.getZ()));

            newEntity.teleportTo(
                    surfacePos.getX() + 0.5,
                    surfacePos.getY() + 1,
                    surfacePos.getZ() + 0.5
            );
            return newEntity;
        }

        /* ===============================
           ENTERING CUSTOM DIMENSION
           =============================== */

        // Respect X/Z, force Y
        BlockPos targetPos = new BlockPos(
                Mth.floor(entity.getX()),
                165,
                Mth.floor(entity.getZ())
        );

        // Ensure chunk is loaded
        destinationLevel.getChunkAt(targetPos);

        // Create platform + portal only if missing
        if (destinationLevel.getBlockState(targetPos.below()).isAir()) {
            createPlatform(destinationLevel, targetPos);
            placePortal(destinationLevel, targetPos);
        }

        // Teleport entity
        newEntity.teleportTo(
                targetPos.getX() + 0.5,
                targetPos.getY() + 1,
                targetPos.getZ() + 0.5
        );

        return newEntity;
    }

    /* ===============================
       PLATFORM CREATION
       =============================== */
    private void createPlatform(ServerLevel level, BlockPos center) {
        int radius = 3;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                level.setBlockAndUpdate(
                        center.offset(x, -1, z),
                        ModBlocks.NOVARITE_BRICK_BLOCK.get().defaultBlockState()
                );
            }
        }
    }

    /* ===============================
       PORTAL PLACEMENT
       =============================== */
    private void placePortal(ServerLevel level, BlockPos pos) {
        level.setBlockAndUpdate(
                pos,
                ModBlocks.NOVARITE_BLOCK.get().defaultBlockState()
        );
    }

    private BlockPos findSurface(ServerLevel level, BlockPos pos) {
        int surfaceY = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos.getX(), pos.getZ());
        return new BlockPos(pos.getX(), surfaceY, pos.getZ());
    }
}