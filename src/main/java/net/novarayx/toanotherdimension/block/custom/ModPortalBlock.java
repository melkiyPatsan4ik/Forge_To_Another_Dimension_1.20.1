package net.novarayx.toanotherdimension.block.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.novarayx.toanotherdimension.worldgen.dimension.ModDimensions;
import net.novarayx.toanotherdimension.worldgen.portal.ModTeleporter;

public class ModPortalBlock extends Block {
    public ModPortalBlock(Properties pProperties) {
        super(pProperties);
    }


    private static final String PORTAL_TIMER = "NovaritePortalTime";
    private static final int REQUIRED_TICKS = 100; // 5 seconds

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (level.isClientSide) return;

        CompoundTag data = entity.getPersistentData();
        int time = data.getInt(PORTAL_TIMER) + 1;

        data.putInt(PORTAL_TIMER, time);


        if (time >= REQUIRED_TICKS) {
            data.remove(PORTAL_TIMER);
            handleKaupenPortal(entity, pos);
        }
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handleKaupenPortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.NOVARAYDIM_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.NOVARAYDIM_LEVEL_KEY;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if (resourcekey == ModDimensions.NOVARAYDIM_LEVEL_KEY) {
                    CompoundTag tag = player.getPersistentData();
                    BlockPos pos = player.blockPosition();

                    tag.putInt("novaray_return_x", pos.getX());
                    tag.putInt("novaray_return_y", pos.getY());
                    tag.putInt("novaray_return_z", pos.getZ());
                    player.changeDimension(portalDimension, new ModTeleporter());
                } else {
                    player.changeDimension(portalDimension, new ModTeleporter());
                }
            }
        }
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        // do nothing, but REQUIRED so stepOn works properly
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);
    }

}
