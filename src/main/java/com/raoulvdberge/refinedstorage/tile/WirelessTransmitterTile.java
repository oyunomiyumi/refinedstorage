package com.raoulvdberge.refinedstorage.tile;

import com.raoulvdberge.refinedstorage.RSTiles;
import com.raoulvdberge.refinedstorage.apiimpl.network.node.WirelessTransmitterNetworkNode;
import com.raoulvdberge.refinedstorage.tile.data.TileDataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class WirelessTransmitterTile extends NetworkNodeTile<WirelessTransmitterNetworkNode> {
    public static final TileDataParameter<Integer, WirelessTransmitterTile> RANGE = new TileDataParameter<>(DataSerializers.VARINT, 0, t -> t.getNode().getRange());

    public WirelessTransmitterTile() {
        super(RSTiles.WIRELESS_TRANSMITTER);
        
        dataManager.addWatchedParameter(RANGE);
    }

    @Override
    @Nonnull
    public WirelessTransmitterNetworkNode createNode(World world, BlockPos pos) {
        return new WirelessTransmitterNetworkNode(world, pos);
    }
}
