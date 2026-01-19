package net.novarayx.toanotherdimension.worldgen.portal;

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
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class ModTeleporter implements ITeleporter {

    private final BlockPos portalPos;
    private final boolean insideDimension;

    public ModTeleporter(BlockPos pos, boolean insideDimension) {
        this.portalPos = pos;
        this.insideDimension = insideDimension;
    }

    @Override
    public Entity placeEntity(
            Entity entity,
            ServerLevel currentWorld,
            ServerLevel destinationWorld,
            float yaw,
            Function<Boolean, Entity> repositionEntity
    ) {
        //TODO: Build a platform in the dimension.

        // Let Minecraft create / move the entity
        return repositionEntity.apply(false);
    }

    @Override
    public @Nullable PortalInfo getPortalInfo(
            Entity entity,
            ServerLevel destinationWorld,
            Function<ServerLevel, PortalInfo> defaultPortalInfo
    ) {
        BlockPos spawnPos = destinationWorld.getSharedSpawnPos();

        BlockPos topPos = destinationWorld.getHeightmapPos(
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                spawnPos
        );

        return new PortalInfo(
                new Vec3(
                        topPos.getX() + 0.5,
                         insideDimension? 165 : topPos.getY() ,
                        topPos.getZ() + 0.5
                ),
                entity.getDeltaMovement(),
                entity.getYRot(),
                entity.getXRot()
        );
    }
}