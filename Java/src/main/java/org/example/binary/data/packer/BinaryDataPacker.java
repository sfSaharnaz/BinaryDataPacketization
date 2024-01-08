package org.example.binary.data.packer;


public class BinaryDataPacker
{
    public BinaryDataPacker() {
    }

    public void addPacketBuilder(PacketBuilder packet_builder) { }
    public void addSOFBuilder(HeaderBuilder header_builder) { }
    public void addEOFBuilder(HeaderBuilder header_builder) { }

    public DataPacket getPackedData(DataPacket rawPacket) { return null; }
    public DataPacket getUnpackedData(DataPacket packedData) { return null; }
}
