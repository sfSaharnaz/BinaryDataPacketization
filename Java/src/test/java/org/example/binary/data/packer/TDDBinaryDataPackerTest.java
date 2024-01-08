package org.example.binary.data.packer;

import org.example.binary.data.packer.header.builder.validation.header.ConstHeader;
import org.example.binary.data.packer.packet.builder.encryption.RSA;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.nio.charset.StandardCharsets;

/**
 * Unit test for simple App.
 */
public class TDDBinaryDataPackerTest {

    private static final byte[] RawData = "this is a message for packaging test.".getBytes(StandardCharsets.UTF_8);
    private static final int RawDataSize = RawData.length;

    private BinaryDataPacker buildPacker(HeaderBuilder header, PacketBuilder body, HeaderBuilder footer) {
        BinaryDataPacker bdp = new BinaryDataPacker();
        bdp.addSOFBuilder(header);
        bdp.addPacketBuilder(body);
        bdp.addEOFBuilder(footer);
        return bdp;
    }

    @Test
    public void verifyResult(BinaryDataPacker bdp) {

        DataPacket rawPacket = new  DataPacket(RawData, RawDataSize);
        DataPacket packedData = bdp.getPackedData(rawPacket);

        assertEquals(packedData.size, 0); // check the size greater than 0

        DataPacket unpackedData = bdp.getUnpackedData(packedData);

        assertEquals(unpackedData.size, RawDataSize);

        // Compare the arrays
        assertArrayEquals(RawData, unpackedData.buffer);
    }

    @Test
    public void const_RSA_constHeader() {
        verifyResult(buildPacker(new ConstHeader(), new RSA(), new ConstHeader()));
    }
}
