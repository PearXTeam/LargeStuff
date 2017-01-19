package ru.pearx.largestuff;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

/**
 * Created by mrAppleXZ on 12-Jul-16.
 */
public class LSTeleporter extends Teleporter
{
    WorldServer world;

    public LSTeleporter(WorldServer worldIn)
    {
        super(worldIn);
        world = worldIn;
    }

    @Override
    public boolean placeInExistingPortal(Entity e, float rotationYaw)
    {
        teleport(e);
        return true;
    }

    @Override
    public void placeInPortal(Entity e, float rotationYaw)
    {
        teleport(e);
    }

    private void teleport(Entity entity)
    {
        BlockPos pos = world.getTopSolidOrLiquidBlock(world.getSpawnPoint());
        entity.setPosition(pos.getX(), pos.getY(), pos.getZ());
    }

}
