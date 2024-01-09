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
    public void verifyConst_RSA_ConstHeader()
    {
        verifyResult(buildPacker(new ConstHeader(), new RSA(), new ConstHeader()));
    }

    @Test
    public void verifyConst_RSA_Checksum()
    {
        verifyResult(buildPacker(new ConstHeader(), new RSA(), new Checksum()));
    }

    @Test
    public void verifyConst_RSA_CRC8()
    {
        verifyResult(buildPacker(new ConstHeader(), new RSA(), new CRC8()));
    }

    @Test
    public void verifyConst_RSA_CRC16()
    {
        verifyResult(buildPacker(new ConstHeader(), new RSA(), new CRC16()));
    }

    @Test
    public void verifyConst_RSA_CRC32()
    {
        verifyResult(buildPacker(new ConstHeader(), new RSA(), new CRC32()));
    }

    @Test
    public void verifyConst_RSA_CRC64()
    {
        verifyResult(buildPacker(new ConstHeader(), new RSA(), new CRC64()));
    }

    @Test
    public void verifyConst_RSA_XOr()
    {
        verifyResult(buildPacker(new ConstHeader(), new RSA(), new XOr()));
    }

    @Test
    public void verifyConst_RSA_Hash()
    {
        verifyResult(buildPacker(new ConstHeader(), new RSA(), new Hash()));
    }

    @Test
    public void verifyConst_AES_ConstHeader()
    {
        verifyResult(buildPacker(new ConstHeader(), new AES(), new ConstHeader()));
    }

    @Test
    public void verifyConst_AES_Checksum()
    {
        verifyResult(buildPacker(new ConstHeader(), new AES(), new Checksum()));
    }

    @Test
    public void verifyConst_AES_CRC8()
    {
        verifyResult(buildPacker(new ConstHeader(), new AES(), new CRC8()));
    }

    @Test
    public void verifyConst_AES_CRC16()
    {
        verifyResult(buildPacker(new ConstHeader(), new AES(), new CRC16()));
    }

    @Test
    public void verifyConst_AES_CRC32()
    {
        verifyResult(buildPacker(new ConstHeader(), new AES(), new CRC32()));
    }

    @Test
    public void verifyConst_AES_CRC64()
    {
        verifyResult(buildPacker(new ConstHeader(), new AES(), new CRC64()));
    }

    @Test
    public void verifyConst_AES_XOr()
    {
        verifyResult(buildPacker(new ConstHeader(), new AES(), new XOr()));
    }

    @Test
    public void verifyConst_AES_Hash()
    {
        verifyResult(buildPacker(new ConstHeader(), new AES(), new Hash()));
    }

    @Test
    public void verifyConst_DES_ConstHeader()
    {
        verifyResult(buildPacker(new ConstHeader(), new DES(), new ConstHeader()));
    }

    @Test
    public void verifyConst_DES_Checksum()
    {
        verifyResult(buildPacker(new ConstHeader(), new DES(), new Checksum()));
    }

    @Test
    public void verifyConst_DES_CRC8()
    {
        verifyResult(buildPacker(new ConstHeader(), new DES(), new CRC8()));
    }

    @Test
    public void verifyConst_DES_CRC16()
    {
        verifyResult(buildPacker(new ConstHeader(), new DES(), new CRC16()));
    }

    @Test
    public void verifyConst_DES_CRC32()
    {
        verifyResult(buildPacker(new ConstHeader(), new DES(), new CRC32()));
    }

    @Test
    public void verifyConst_DES_CRC64()
    {
        verifyResult(buildPacker(new ConstHeader(), new DES(), new CRC64()));
    }

    @Test
    public void verifyConst_DES_XOr()
    {
        verifyResult(buildPacker(new ConstHeader(), new DES(), new XOr()));
    }

    @Test
    public void verifyConst_DES_Hash()
    {
        verifyResult(buildPacker(new ConstHeader(), new DES(), new Hash()));
    }

    @Test
    public void verifyConst_TwoFish_ConstHeader()
    {
        verifyResult(buildPacker(new ConstHeader(), new TwoFish(), new ConstHeader()));
    }

    @Test
    public void verifyConst_TwoFish_Checksum()
    {
        verifyResult(buildPacker(new ConstHeader(), new TwoFish(), new Checksum()));
    }

    @Test
    public void verifyConst_TwoFish_CRC8()
    {
        verifyResult(buildPacker(new ConstHeader(), new TwoFish(), new CRC8()));
    }

    @Test
    public void verifyConst_TwoFish_CRC16()
    {
        verifyResult(buildPacker(new ConstHeader(), new TwoFish(), new CRC16()));
    }

    @Test
    public void verifyConst_TwoFish_CRC32()
    {
        verifyResult(buildPacker(new ConstHeader(), new TwoFish(), new CRC32()));
    }

    @Test
    public void verifyConst_TwoFish_CRC64()
    {
        verifyResult(buildPacker(new ConstHeader(), new TwoFish(), new CRC64()));
    }

    @Test
    public void verifyConst_TwoFish_XOr()
    {
        verifyResult(buildPacker(new ConstHeader(), new TwoFish(), new XOr()));
    }

    @Test
    public void verifyConst_TwoFish_Hash()
    {
        verifyResult(buildPacker(new ConstHeader(), new TwoFish(), new Hash()));
    }

    @Test
    public void verifyConst_DEFLATE_ConstHeader()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.DEFLATE(), new ConstHeader()));
    }

    @Test
    public void verifyConst_DEFLATE_Checksum()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.DEFLATE(), new Checksum()));
    }

    @Test
    public void verifyConst_DEFLATE_CRC8()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.DEFLATE(), new CRC8()));
    }

    @Test
    public void verifyConst_DEFLATE_CRC16()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.DEFLATE(), new CRC16()));
    }

    @Test
    public void verifyConst_DEFLATE_CRC32()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.DEFLATE(), new CRC32()));
    }

    @Test
    public void verifyConst_DEFLATE_CRC64()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.DEFLATE(), new CRC64()));
    }

    @Test
    public void verifyConst_DEFLATE_XOr()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.DEFLATE(), new XOr()));
    }

    @Test
    public void verifyConst_DEFLATE_Hash()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.DEFLATE(), new Hash()));
    }

    @Test
    public void verifyConst_Huffman_ConstHeader()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Huffman(), new ConstHeader()));
    }

    @Test
    public void verifyConst_Huffman_Checksum()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Huffman(), new Checksum()));
    }

    @Test
    public void verifyConst_Huffman_CRC8()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Huffman(), new CRC8()));
    }

    @Test
    public void verifyConst_Huffman_CRC16()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Huffman(), new CRC16()));
    }

    @Test
    public void verifyConst_Huffman_CRC32()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Huffman(), new CRC32()));
    }

    @Test
    public void verifyConst_Huffman_CRC64()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Huffman(), new CRC64()));
    }

    @Test
    public void verifyConst_Huffman_XOr()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Huffman(), new XOr()));
    }

    @Test
    public void verifyConst_Huffman_Hash()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Huffman(), new Hash()));
    }

    @Test
    public void verifyConst_Arithmetic_ConstHeader()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Arithmetic(), new ConstHeader()));
    }

    @Test
    public void verifyConst_Arithmetic_Checksum()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Arithmetic(), new Checksum()));
    }

    @Test
    public void verifyConst_Arithmetic_CRC8()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Arithmetic(), new CRC8()));
    }

    @Test
    public void verifyConst_Arithmetic_CRC16()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Arithmetic(), new CRC16()));
    }

    @Test
    public void verifyConst_Arithmetic_CRC32()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Arithmetic(), new CRC32()));
    }

    @Test
    public void verifyConst_Arithmetic_CRC64()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Arithmetic(), new CRC64()));
    }

    @Test
    public void verifyConst_Arithmetic_XOr()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Arithmetic(), new XOr()));
    }

    @Test
    public void verifyConst_Arithmetic_Hash()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.Arithmetic(), new Hash()));
    }

    @Test
    public void verifyConst_JPEG_ConstHeader()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.JPEG(), new ConstHeader()));
    }

    @Test
    public void verifyConst_JPEG_Checksum()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.JPEG(), new Checksum()));
    }

    @Test
    public void verifyConst_JPEG_CRC8()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.JPEG(), new CRC8()));
    }

    @Test
    public void verifyConst_JPEG_CRC16()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.JPEG(), new CRC16()));
    }

    @Test
    public void verifyConst_JPEG_CRC32()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.JPEG(), new CRC32()));
    }

    @Test
    public void verifyConst_JPEG_CRC64()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.JPEG(), new CRC64()));
    }

    @Test
    public void verifyConst_JPEG_XOr()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.JPEG(), new XOr()));
    }

    @Test
    public void verifyConst_JPEG_Hash()
    {
        verifyResult(buildPacker(new ConstHeader(), new PacketBuilder.Compressor.JPEG(), new Hash()));
    }

    @Test
    public void verifyChecksum_RSA_ConstHeader()
    {
        verifyResult(buildPacker(new Checksum(), new RSA(), new ConstHeader()));
    }

    @Test
    public void verifyChecksum_RSA_Checksum()
    {
        verifyResult(buildPacker(new Checksum(), new RSA(), new Checksum()));
    }

    @Test
    public void verifyChecksum_RSA_CRC8()
    {
        verifyResult(buildPacker(new Checksum(), new RSA(), new CRC8()));
    }

    @Test
    public void verifyChecksum_RSA_CRC16()
    {
        verifyResult(buildPacker(new Checksum(), new RSA(), new CRC16()));
    }

    @Test
    public void verifyChecksum_RSA_CRC32()
    {
        verifyResult(buildPacker(new Checksum(), new RSA(), new CRC32()));
    }

    @Test
    public void verifyChecksum_RSA_CRC64()
    {
        verifyResult(buildPacker(new Checksum(), new RSA(), new CRC64()));
    }

    @Test
    public void verifyChecksum_RSA_XOr()
    {
        verifyResult(buildPacker(new Checksum(), new RSA(), new XOr()));
    }

    @Test
    public void verifyChecksum_RSA_Hash()
    {
        verifyResult(buildPacker(new Checksum(), new RSA(), new Hash()));
    }

    @Test
    public void verifyChecksum_AES_ConstHeader()
    {
        verifyResult(buildPacker(new Checksum(), new AES(), new ConstHeader()));
    }

    @Test
    public void verifyChecksum_AES_Checksum()
    {
        verifyResult(buildPacker(new Checksum(), new AES(), new Checksum()));
    }

    @Test
    public void verifyChecksum_AES_CRC8()
    {
        verifyResult(buildPacker(new Checksum(), new AES(), new CRC8()));
    }

    @Test
    public void verifyChecksum_AES_CRC16()
    {
        verifyResult(buildPacker(new Checksum(), new AES(), new CRC16()));
    }

    @Test
    public void verifyChecksum_AES_CRC32()
    {
        verifyResult(buildPacker(new Checksum(), new AES(), new CRC32()));
    }

    @Test
    public void verifyChecksum_AES_CRC64()
    {
        verifyResult(buildPacker(new Checksum(), new AES(), new CRC64()));
    }

    @Test
    public void verifyChecksum_AES_XOr()
    {
        verifyResult(buildPacker(new Checksum(), new AES(), new XOr()));
    }

    @Test
    public void verifyChecksum_AES_Hash()
    {
        verifyResult(buildPacker(new Checksum(), new AES(), new Hash()));
    }

    @Test
    public void verifyChecksum_DES_ConstHeader()
    {
        verifyResult(buildPacker(new Checksum(), new DES(), new ConstHeader()));
    }

    @Test
    public void verifyChecksum_DES_Checksum()
    {
        verifyResult(buildPacker(new Checksum(), new DES(), new Checksum()));
    }

    @Test
    public void verifyChecksum_DES_CRC8()
    {
        verifyResult(buildPacker(new Checksum(), new DES(), new CRC8()));
    }

    @Test
    public void verifyChecksum_DES_CRC16()
    {
        verifyResult(buildPacker(new Checksum(), new DES(), new CRC16()));
    }

    @Test
    public void verifyChecksum_DES_CRC32()
    {
        verifyResult(buildPacker(new Checksum(), new DES(), new CRC32()));
    }

    @Test
    public void verifyChecksum_DES_CRC64()
    {
        verifyResult(buildPacker(new Checksum(), new DES(), new CRC64()));
    }

    @Test
    public void verifyChecksum_DES_XOr()
    {
        verifyResult(buildPacker(new Checksum(), new DES(), new XOr()));
    }

    @Test
    public void verifyChecksum_DES_Hash()
    {
        verifyResult(buildPacker(new Checksum(), new DES(), new Hash()));
    }

    @Test
    public void verifyChecksum_TwoFish_ConstHeader()
    {
        verifyResult(buildPacker(new Checksum(), new TwoFish(), new ConstHeader()));
    }

    @Test
    public void verifyChecksum_TwoFish_Checksum()
    {
        verifyResult(buildPacker(new Checksum(), new TwoFish(), new Checksum()));
    }

    @Test
    public void verifyChecksum_TwoFish_CRC8()
    {
        verifyResult(buildPacker(new Checksum(), new TwoFish(), new CRC8()));
    }

    @Test
    public void verifyChecksum_TwoFish_CRC16()
    {
        verifyResult(buildPacker(new Checksum(), new TwoFish(), new CRC16()));
    }

    @Test
    public void verifyChecksum_TwoFish_CRC32()
    {
        verifyResult(buildPacker(new Checksum(), new TwoFish(), new CRC32()));
    }

    @Test
    public void verifyChecksum_TwoFish_CRC64()
    {
        verifyResult(buildPacker(new Checksum(), new TwoFish(), new CRC64()));
    }

    @Test
    public void verifyChecksum_TwoFish_XOr()
    {
        verifyResult(buildPacker(new Checksum(), new TwoFish(), new XOr()));
    }

    @Test
    public void verifyChecksum_TwoFish_Hash()
    {
        verifyResult(buildPacker(new Checksum(), new TwoFish(), new Hash()));
    }

    @Test
    public void verifyChecksum_DEFLATE_ConstHeader()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.DEFLATE(), new ConstHeader()));
    }

    @Test
    public void verifyChecksum_DEFLATE_Checksum()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.DEFLATE(), new Checksum()));
    }

    @Test
    public void verifyChecksum_DEFLATE_CRC8()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.DEFLATE(), new CRC8()));
    }

    @Test
    public void verifyChecksum_DEFLATE_CRC16()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.DEFLATE(), new CRC16()));
    }

    @Test
    public void verifyChecksum_DEFLATE_CRC32()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.DEFLATE(), new CRC32()));
    }

    @Test
    public void verifyChecksum_DEFLATE_CRC64()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.DEFLATE(), new CRC64()));
    }

    @Test
    public void verifyChecksum_DEFLATE_XOr()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.DEFLATE(), new XOr()));
    }

    @Test
    public void verifyChecksum_DEFLATE_Hash()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.DEFLATE(), new Hash()));
    }

    @Test
    public void verifyChecksum_Huffman_ConstHeader()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Huffman(), new ConstHeader()));
    }

    @Test
    public void verifyChecksum_Huffman_Checksum()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Huffman(), new Checksum()));
    }

    @Test
    public void verifyChecksum_Huffman_CRC8()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Huffman(), new CRC8()));
    }

    @Test
    public void verifyChecksum_Huffman_CRC16()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Huffman(), new CRC16()));
    }

    @Test
    public void verifyChecksum_Huffman_CRC32()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Huffman(), new CRC32()));
    }

    @Test
    public void verifyChecksum_Huffman_CRC64()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Huffman(), new CRC64()));
    }

    @Test
    public void verifyChecksum_Huffman_XOr()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Huffman(), new XOr()));
    }

    @Test
    public void verifyChecksum_Huffman_Hash()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Huffman(), new Hash()));
    }

    @Test
    public void verifyChecksum_Arithmetic_ConstHeader()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Arithmetic(), new ConstHeader()));
    }

    @Test
    public void verifyChecksum_Arithmetic_Checksum()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Arithmetic(), new Checksum()));
    }

    @Test
    public void verifyChecksum_Arithmetic_CRC8()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Arithmetic(), new CRC8()));
    }

    @Test
    public void verifyChecksum_Arithmetic_CRC16()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Arithmetic(), new CRC16()));
    }

    @Test
    public void verifyChecksum_Arithmetic_CRC32()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Arithmetic(), new CRC32()));
    }

    @Test
    public void verifyChecksum_Arithmetic_CRC64()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Arithmetic(), new CRC64()));
    }

    @Test
    public void verifyChecksum_Arithmetic_XOr()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Arithmetic(), new XOr()));
    }

    @Test
    public void verifyChecksum_Arithmetic_Hash()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.Arithmetic(), new Hash()));
    }

    @Test
    public void verifyChecksum_JPEG_ConstHeader()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.JPEG(), new ConstHeader()));
    }

    @Test
    public void verifyChecksum_JPEG_Checksum()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.JPEG(), new Checksum()));
    }

    @Test
    public void verifyChecksum_JPEG_CRC8()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.JPEG(), new CRC8()));
    }

    @Test
    public void verifyChecksum_JPEG_CRC16()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.JPEG(), new CRC16()));
    }

    @Test
    public void verifyChecksum_JPEG_CRC32()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.JPEG(), new CRC32()));
    }

    @Test
    public void verifyChecksum_JPEG_CRC64()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.JPEG(), new CRC64()));
    }

    @Test
    public void verifyChecksum_JPEG_XOr()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.JPEG(), new XOr()));
    }

    @Test
    public void verifyChecksum_JPEG_Hash()
    {
        verifyResult(buildPacker(new Checksum(), new PacketBuilder.Compressor.JPEG(), new Hash()));
    }

    @Test
    public void verifyCRC8_RSA_ConstHeader()
    {
        verifyResult(buildPacker(new CRC8(), new RSA(), new ConstHeader()));
    }

    @Test
    public void verifyCRC8_RSA_Checksum()
    {
        verifyResult(buildPacker(new CRC8(), new RSA(), new Checksum()));
    }

    @Test
    public void verifyCRC8_RSA_CRC8()
    {
        verifyResult(buildPacker(new CRC8(), new RSA(), new CRC8()));
    }

    @Test
    public void verifyCRC8_RSA_CRC16()
    {
        verifyResult(buildPacker(new CRC8(), new RSA(), new CRC16()));
    }

    @Test
    public void verifyCRC8_RSA_CRC32()
    {
        verifyResult(buildPacker(new CRC8(), new RSA(), new CRC32()));
    }

    @Test
    public void verifyCRC8_RSA_CRC64()
    {
        verifyResult(buildPacker(new CRC8(), new RSA(), new CRC64()));
    }

    @Test
    public void verifyCRC8_RSA_XOr()
    {
        verifyResult(buildPacker(new CRC8(), new RSA(), new XOr()));
    }

    @Test
    public void verifyCRC8_RSA_Hash()
    {
        verifyResult(buildPacker(new CRC8(), new RSA(), new Hash()));
    }

    @Test
    public void verifyCRC8_AES_ConstHeader()
    {
        verifyResult(buildPacker(new CRC8(), new AES(), new ConstHeader()));
    }

    @Test
    public void verifyCRC8_AES_Checksum()
    {
        verifyResult(buildPacker(new CRC8(), new AES(), new Checksum()));
    }

    @Test
    public void verifyCRC8_AES_CRC8()
    {
        verifyResult(buildPacker(new CRC8(), new AES(), new CRC8()));
    }

    @Test
    public void verifyCRC8_AES_CRC16()
    {
        verifyResult(buildPacker(new CRC8(), new AES(), new CRC16()));
    }

    @Test
    public void verifyCRC8_AES_CRC32()
    {
        verifyResult(buildPacker(new CRC8(), new AES(), new CRC32()));
    }

    @Test
    public void verifyCRC8_AES_CRC64()
    {
        verifyResult(buildPacker(new CRC8(), new AES(), new CRC64()));
    }

    @Test
    public void verifyCRC8_AES_XOr()
    {
        verifyResult(buildPacker(new CRC8(), new AES(), new XOr()));
    }

    @Test
    public void verifyCRC8_AES_Hash()
    {
        verifyResult(buildPacker(new CRC8(), new AES(), new Hash()));
    }

    @Test
    public void verifyCRC8_DES_ConstHeader()
    {
        verifyResult(buildPacker(new CRC8(), new DES(), new ConstHeader()));
    }

    @Test
    public void verifyCRC8_DES_Checksum()
    {
        verifyResult(buildPacker(new CRC8(), new DES(), new Checksum()));
    }

    @Test
    public void verifyCRC8_DES_CRC8()
    {
        verifyResult(buildPacker(new CRC8(), new DES(), new CRC8()));
    }

    @Test
    public void verifyCRC8_DES_CRC16()
    {
        verifyResult(buildPacker(new CRC8(), new DES(), new CRC16()));
    }

    @Test
    public void verifyCRC8_DES_CRC32()
    {
        verifyResult(buildPacker(new CRC8(), new DES(), new CRC32()));
    }

    @Test
    public void verifyCRC8_DES_CRC64()
    {
        verifyResult(buildPacker(new CRC8(), new DES(), new CRC64()));
    }

    @Test
    public void verifyCRC8_DES_XOr()
    {
        verifyResult(buildPacker(new CRC8(), new DES(), new XOr()));
    }

    @Test
    public void verifyCRC8_DES_Hash()
    {
        verifyResult(buildPacker(new CRC8(), new DES(), new Hash()));
    }

    @Test
    public void verifyCRC8_TwoFish_ConstHeader()
    {
        verifyResult(buildPacker(new CRC8(), new TwoFish(), new ConstHeader()));
    }

    @Test
    public void verifyCRC8_TwoFish_Checksum()
    {
        verifyResult(buildPacker(new CRC8(), new TwoFish(), new Checksum()));
    }

    @Test
    public void verifyCRC8_TwoFish_CRC8()
    {
        verifyResult(buildPacker(new CRC8(), new TwoFish(), new CRC8()));
    }

    @Test
    public void verifyCRC8_TwoFish_CRC16()
    {
        verifyResult(buildPacker(new CRC8(), new TwoFish(), new CRC16()));
    }

    @Test
    public void verifyCRC8_TwoFish_CRC32()
    {
        verifyResult(buildPacker(new CRC8(), new TwoFish(), new CRC32()));
    }

    @Test
    public void verifyCRC8_TwoFish_CRC64()
    {
        verifyResult(buildPacker(new CRC8(), new TwoFish(), new CRC64()));
    }

    @Test
    public void verifyCRC8_TwoFish_XOr()
    {
        verifyResult(buildPacker(new CRC8(), new TwoFish(), new XOr()));
    }

    @Test
    public void verifyCRC8_TwoFish_Hash()
    {
        verifyResult(buildPacker(new CRC8(), new TwoFish(), new Hash()));
    }

    @Test
    public void verifyCRC8_DEFLATE_ConstHeader()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.DEFLATE(), new ConstHeader()));
    }

    @Test
    public void verifyCRC8_DEFLATE_Checksum()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.DEFLATE(), new Checksum()));
    }

    @Test
    public void verifyCRC8_DEFLATE_CRC8()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.DEFLATE(), new CRC8()));
    }

    @Test
    public void verifyCRC8_DEFLATE_CRC16()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.DEFLATE(), new CRC16()));
    }

    @Test
    public void verifyCRC8_DEFLATE_CRC32()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.DEFLATE(), new CRC32()));
    }

    @Test
    public void verifyCRC8_DEFLATE_CRC64()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.DEFLATE(), new CRC64()));
    }

    @Test
    public void verifyCRC8_DEFLATE_XOr()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.DEFLATE(), new XOr()));
    }

    @Test
    public void verifyCRC8_DEFLATE_Hash()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.DEFLATE(), new Hash()));
    }

    @Test
    public void verifyCRC8_Huffman_ConstHeader()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Huffman(), new ConstHeader()));
    }

    @Test
    public void verifyCRC8_Huffman_Checksum()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Huffman(), new Checksum()));
    }

    @Test
    public void verifyCRC8_Huffman_CRC8()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Huffman(), new CRC8()));
    }

    @Test
    public void verifyCRC8_Huffman_CRC16()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Huffman(), new CRC16()));
    }

    @Test
    public void verifyCRC8_Huffman_CRC32()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Huffman(), new CRC32()));
    }

    @Test
    public void verifyCRC8_Huffman_CRC64()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Huffman(), new CRC64()));
    }

    @Test
    public void verifyCRC8_Huffman_XOr()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Huffman(), new XOr()));
    }

    @Test
    public void verifyCRC8_Huffman_Hash()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Huffman(), new Hash()));
    }

    @Test
    public void verifyCRC8_Arithmetic_ConstHeader()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Arithmetic(), new ConstHeader()));
    }

    @Test
    public void verifyCRC8_Arithmetic_Checksum()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Arithmetic(), new Checksum()));
    }

    @Test
    public void verifyCRC8_Arithmetic_CRC8()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Arithmetic(), new CRC8()));
    }

    @Test
    public void verifyCRC8_Arithmetic_CRC16()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Arithmetic(), new CRC16()));
    }

    @Test
    public void verifyCRC8_Arithmetic_CRC32()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Arithmetic(), new CRC32()));
    }

    @Test
    public void verifyCRC8_Arithmetic_CRC64()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Arithmetic(), new CRC64()));
    }

    @Test
    public void verifyCRC8_Arithmetic_XOr()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Arithmetic(), new XOr()));
    }

    @Test
    public void verifyCRC8_Arithmetic_Hash()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.Arithmetic(), new Hash()));
    }

    @Test
    public void verifyCRC8_JPEG_ConstHeader()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.JPEG(), new ConstHeader()));
    }

    @Test
    public void verifyCRC8_JPEG_Checksum()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.JPEG(), new Checksum()));
    }

    @Test
    public void verifyCRC8_JPEG_CRC8()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.JPEG(), new CRC8()));
    }

    @Test
    public void verifyCRC8_JPEG_CRC16()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.JPEG(), new CRC16()));
    }

    @Test
    public void verifyCRC8_JPEG_CRC32()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.JPEG(), new CRC32()));
    }

    @Test
    public void verifyCRC8_JPEG_CRC64()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.JPEG(), new CRC64()));
    }

    @Test
    public void verifyCRC8_JPEG_XOr()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.JPEG(), new XOr()));
    }

    @Test
    public void verifyCRC8_JPEG_Hash()
    {
        verifyResult(buildPacker(new CRC8(), new PacketBuilder.Compressor.JPEG(), new Hash()));
    }

    @Test
    public void verifyCRC16_RSA_ConstHeader()
    {
        verifyResult(buildPacker(new CRC16(), new RSA(), new ConstHeader()));
    }

    @Test
    public void verifyCRC16_RSA_Checksum()
    {
        verifyResult(buildPacker(new CRC16(), new RSA(), new Checksum()));
    }

    @Test
    public void verifyCRC16_RSA_CRC8()
    {
        verifyResult(buildPacker(new CRC16(), new RSA(), new CRC8()));
    }

    @Test
    public void verifyCRC16_RSA_CRC16()
    {
        verifyResult(buildPacker(new CRC16(), new RSA(), new CRC16()));
    }

    @Test
    public void verifyCRC16_RSA_CRC32()
    {
        verifyResult(buildPacker(new CRC16(), new RSA(), new CRC32()));
    }

    @Test
    public void verifyCRC16_RSA_CRC64()
    {
        verifyResult(buildPacker(new CRC16(), new RSA(), new CRC64()));
    }

    @Test
    public void verifyCRC16_RSA_XOr()
    {
        verifyResult(buildPacker(new CRC16(), new RSA(), new XOr()));
    }

    @Test
    public void verifyCRC16_RSA_Hash()
    {
        verifyResult(buildPacker(new CRC16(), new RSA(), new Hash()));
    }

    @Test
    public void verifyCRC16_AES_ConstHeader()
    {
        verifyResult(buildPacker(new CRC16(), new AES(), new ConstHeader()));
    }

    @Test
    public void verifyCRC16_AES_Checksum()
    {
        verifyResult(buildPacker(new CRC16(), new AES(), new Checksum()));
    }

    @Test
    public void verifyCRC16_AES_CRC8()
    {
        verifyResult(buildPacker(new CRC16(), new AES(), new CRC8()));
    }

    @Test
    public void verifyCRC16_AES_CRC16()
    {
        verifyResult(buildPacker(new CRC16(), new AES(), new CRC16()));
    }

    @Test
    public void verifyCRC16_AES_CRC32()
    {
        verifyResult(buildPacker(new CRC16(), new AES(), new CRC32()));
    }

    @Test
    public void verifyCRC16_AES_CRC64()
    {
        verifyResult(buildPacker(new CRC16(), new AES(), new CRC64()));
    }

    @Test
    public void verifyCRC16_AES_XOr()
    {
        verifyResult(buildPacker(new CRC16(), new AES(), new XOr()));
    }

    @Test
    public void verifyCRC16_AES_Hash()
    {
        verifyResult(buildPacker(new CRC16(), new AES(), new Hash()));
    }

    @Test
    public void verifyCRC16_DES_ConstHeader()
    {
        verifyResult(buildPacker(new CRC16(), new DES(), new ConstHeader()));
    }

    @Test
    public void verifyCRC16_DES_Checksum()
    {
        verifyResult(buildPacker(new CRC16(), new DES(), new Checksum()));
    }

    @Test
    public void verifyCRC16_DES_CRC8()
    {
        verifyResult(buildPacker(new CRC16(), new DES(), new CRC8()));
    }

    @Test
    public void verifyCRC16_DES_CRC16()
    {
        verifyResult(buildPacker(new CRC16(), new DES(), new CRC16()));
    }

    @Test
    public void verifyCRC16_DES_CRC32()
    {
        verifyResult(buildPacker(new CRC16(), new DES(), new CRC32()));
    }

    @Test
    public void verifyCRC16_DES_CRC64()
    {
        verifyResult(buildPacker(new CRC16(), new DES(), new CRC64()));
    }

    @Test
    public void verifyCRC16_DES_XOr()
    {
        verifyResult(buildPacker(new CRC16(), new DES(), new XOr()));
    }

    @Test
    public void verifyCRC16_DES_Hash()
    {
        verifyResult(buildPacker(new CRC16(), new DES(), new Hash()));
    }

    @Test
    public void verifyCRC16_TwoFish_ConstHeader()
    {
        verifyResult(buildPacker(new CRC16(), new TwoFish(), new ConstHeader()));
    }

    @Test
    public void verifyCRC16_TwoFish_Checksum()
    {
        verifyResult(buildPacker(new CRC16(), new TwoFish(), new Checksum()));
    }

    @Test
    public void verifyCRC16_TwoFish_CRC8()
    {
        verifyResult(buildPacker(new CRC16(), new TwoFish(), new CRC8()));
    }

    @Test
    public void verifyCRC16_TwoFish_CRC16()
    {
        verifyResult(buildPacker(new CRC16(), new TwoFish(), new CRC16()));
    }

    @Test
    public void verifyCRC16_TwoFish_CRC32()
    {
        verifyResult(buildPacker(new CRC16(), new TwoFish(), new CRC32()));
    }

    @Test
    public void verifyCRC16_TwoFish_CRC64()
    {
        verifyResult(buildPacker(new CRC16(), new TwoFish(), new CRC64()));
    }

    @Test
    public void verifyCRC16_TwoFish_XOr()
    {
        verifyResult(buildPacker(new CRC16(), new TwoFish(), new XOr()));
    }

    @Test
    public void verifyCRC16_TwoFish_Hash()
    {
        verifyResult(buildPacker(new CRC16(), new TwoFish(), new Hash()));
    }

    @Test
    public void verifyCRC16_DEFLATE_ConstHeader()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.DEFLATE(), new ConstHeader()));
    }

    @Test
    public void verifyCRC16_DEFLATE_Checksum()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.DEFLATE(), new Checksum()));
    }

    @Test
    public void verifyCRC16_DEFLATE_CRC8()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.DEFLATE(), new CRC8()));
    }

    @Test
    public void verifyCRC16_DEFLATE_CRC16()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.DEFLATE(), new CRC16()));
    }

    @Test
    public void verifyCRC16_DEFLATE_CRC32()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.DEFLATE(), new CRC32()));
    }

    @Test
    public void verifyCRC16_DEFLATE_CRC64()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.DEFLATE(), new CRC64()));
    }

    @Test
    public void verifyCRC16_DEFLATE_XOr()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.DEFLATE(), new XOr()));
    }

    @Test
    public void verifyCRC16_DEFLATE_Hash()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.DEFLATE(), new Hash()));
    }

    @Test
    public void verifyCRC16_Huffman_ConstHeader()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Huffman(), new ConstHeader()));
    }

    @Test
    public void verifyCRC16_Huffman_Checksum()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Huffman(), new Checksum()));
    }

    @Test
    public void verifyCRC16_Huffman_CRC8()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Huffman(), new CRC8()));
    }

    @Test
    public void verifyCRC16_Huffman_CRC16()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Huffman(), new CRC16()));
    }

    @Test
    public void verifyCRC16_Huffman_CRC32()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Huffman(), new CRC32()));
    }

    @Test
    public void verifyCRC16_Huffman_CRC64()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Huffman(), new CRC64()));
    }

    @Test
    public void verifyCRC16_Huffman_XOr()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Huffman(), new XOr()));
    }

    @Test
    public void verifyCRC16_Huffman_Hash()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Huffman(), new Hash()));
    }

    @Test
    public void verifyCRC16_Arithmetic_ConstHeader()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Arithmetic(), new ConstHeader()));
    }

    @Test
    public void verifyCRC16_Arithmetic_Checksum()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Arithmetic(), new Checksum()));
    }

    @Test
    public void verifyCRC16_Arithmetic_CRC8()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Arithmetic(), new CRC8()));
    }

    @Test
    public void verifyCRC16_Arithmetic_CRC16()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Arithmetic(), new CRC16()));
    }

    @Test
    public void verifyCRC16_Arithmetic_CRC32()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Arithmetic(), new CRC32()));
    }

    @Test
    public void verifyCRC16_Arithmetic_CRC64()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Arithmetic(), new CRC64()));
    }

    @Test
    public void verifyCRC16_Arithmetic_XOr()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Arithmetic(), new XOr()));
    }

    @Test
    public void verifyCRC16_Arithmetic_Hash()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.Arithmetic(), new Hash()));
    }

    @Test
    public void verifyCRC16_JPEG_ConstHeader()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.JPEG(), new ConstHeader()));
    }

    @Test
    public void verifyCRC16_JPEG_Checksum()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.JPEG(), new Checksum()));
    }

    @Test
    public void verifyCRC16_JPEG_CRC8()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.JPEG(), new CRC8()));
    }

    @Test
    public void verifyCRC16_JPEG_CRC16()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.JPEG(), new CRC16()));
    }

    @Test
    public void verifyCRC16_JPEG_CRC32()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.JPEG(), new CRC32()));
    }

    @Test
    public void verifyCRC16_JPEG_CRC64()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.JPEG(), new CRC64()));
    }

    @Test
    public void verifyCRC16_JPEG_XOr()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.JPEG(), new XOr()));
    }

    @Test
    public void verifyCRC16_JPEG_Hash()
    {
        verifyResult(buildPacker(new CRC16(), new PacketBuilder.Compressor.JPEG(), new Hash()));
    }

    @Test
    public void verifyCRC32_RSA_ConstHeader()
    {
        verifyResult(buildPacker(new CRC32(), new RSA(), new ConstHeader()));
    }

    @Test
    public void verifyCRC32_RSA_Checksum()
    {
        verifyResult(buildPacker(new CRC32(), new RSA(), new Checksum()));
    }

    @Test
    public void verifyCRC32_RSA_CRC8()
    {
        verifyResult(buildPacker(new CRC32(), new RSA(), new CRC8()));
    }

    @Test
    public void verifyCRC32_RSA_CRC16()
    {
        verifyResult(buildPacker(new CRC32(), new RSA(), new CRC16()));
    }

    @Test
    public void verifyCRC32_RSA_CRC32()
    {
        verifyResult(buildPacker(new CRC32(), new RSA(), new CRC32()));
    }

    @Test
    public void verifyCRC32_RSA_CRC64()
    {
        verifyResult(buildPacker(new CRC32(), new RSA(), new CRC64()));
    }

    @Test
    public void verifyCRC32_RSA_XOr()
    {
        verifyResult(buildPacker(new CRC32(), new RSA(), new XOr()));
    }

    @Test
    public void verifyCRC32_RSA_Hash()
    {
        verifyResult(buildPacker(new CRC32(), new RSA(), new Hash()));
    }

    @Test
    public void verifyCRC32_AES_ConstHeader()
    {
        verifyResult(buildPacker(new CRC32(), new AES(), new ConstHeader()));
    }

    @Test
    public void verifyCRC32_AES_Checksum()
    {
        verifyResult(buildPacker(new CRC32(), new AES(), new Checksum()));
    }

    @Test
    public void verifyCRC32_AES_CRC8()
    {
        verifyResult(buildPacker(new CRC32(), new AES(), new CRC8()));
    }

    @Test
    public void verifyCRC32_AES_CRC16()
    {
        verifyResult(buildPacker(new CRC32(), new AES(), new CRC16()));
    }

    @Test
    public void verifyCRC32_AES_CRC32()
    {
        verifyResult(buildPacker(new CRC32(), new AES(), new CRC32()));
    }

    @Test
    public void verifyCRC32_AES_CRC64()
    {
        verifyResult(buildPacker(new CRC32(), new AES(), new CRC64()));
    }

    @Test
    public void verifyCRC32_AES_XOr()
    {
        verifyResult(buildPacker(new CRC32(), new AES(), new XOr()));
    }

    @Test
    public void verifyCRC32_AES_Hash()
    {
        verifyResult(buildPacker(new CRC32(), new AES(), new Hash()));
    }

    @Test
    public void verifyCRC32_DES_ConstHeader()
    {
        verifyResult(buildPacker(new CRC32(), new DES(), new ConstHeader()));
    }

    @Test
    public void verifyCRC32_DES_Checksum()
    {
        verifyResult(buildPacker(new CRC32(), new DES(), new Checksum()));
    }

    @Test
    public void verifyCRC32_DES_CRC8()
    {
        verifyResult(buildPacker(new CRC32(), new DES(), new CRC8()));
    }

    @Test
    public void verifyCRC32_DES_CRC16()
    {
        verifyResult(buildPacker(new CRC32(), new DES(), new CRC16()));
    }

    @Test
    public void verifyCRC32_DES_CRC32()
    {
        verifyResult(buildPacker(new CRC32(), new DES(), new CRC32()));
    }

    @Test
    public void verifyCRC32_DES_CRC64()
    {
        verifyResult(buildPacker(new CRC32(), new DES(), new CRC64()));
    }

    @Test
    public void verifyCRC32_DES_XOr()
    {
        verifyResult(buildPacker(new CRC32(), new DES(), new XOr()));
    }

    @Test
    public void verifyCRC32_DES_Hash()
    {
        verifyResult(buildPacker(new CRC32(), new DES(), new Hash()));
    }

    @Test
    public void verifyCRC32_TwoFish_ConstHeader()
    {
        verifyResult(buildPacker(new CRC32(), new TwoFish(), new ConstHeader()));
    }

    @Test
    public void verifyCRC32_TwoFish_Checksum()
    {
        verifyResult(buildPacker(new CRC32(), new TwoFish(), new Checksum()));
    }

    @Test
    public void verifyCRC32_TwoFish_CRC8()
    {
        verifyResult(buildPacker(new CRC32(), new TwoFish(), new CRC8()));
    }

    @Test
    public void verifyCRC32_TwoFish_CRC16()
    {
        verifyResult(buildPacker(new CRC32(), new TwoFish(), new CRC16()));
    }

    @Test
    public void verifyCRC32_TwoFish_CRC32()
    {
        verifyResult(buildPacker(new CRC32(), new TwoFish(), new CRC32()));
    }

    @Test
    public void verifyCRC32_TwoFish_CRC64()
    {
        verifyResult(buildPacker(new CRC32(), new TwoFish(), new CRC64()));
    }

    @Test
    public void verifyCRC32_TwoFish_XOr()
    {
        verifyResult(buildPacker(new CRC32(), new TwoFish(), new XOr()));
    }

    @Test
    public void verifyCRC32_TwoFish_Hash()
    {
        verifyResult(buildPacker(new CRC32(), new TwoFish(), new Hash()));
    }

    @Test
    public void verifyCRC32_DEFLATE_ConstHeader()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.DEFLATE(), new ConstHeader()));
    }

    @Test
    public void verifyCRC32_DEFLATE_Checksum()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.DEFLATE(), new Checksum()));
    }

    @Test
    public void verifyCRC32_DEFLATE_CRC8()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.DEFLATE(), new CRC8()));
    }

    @Test
    public void verifyCRC32_DEFLATE_CRC16()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.DEFLATE(), new CRC16()));
    }

    @Test
    public void verifyCRC32_DEFLATE_CRC32()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.DEFLATE(), new CRC32()));
    }

    @Test
    public void verifyCRC32_DEFLATE_CRC64()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.DEFLATE(), new CRC64()));
    }

    @Test
    public void verifyCRC32_DEFLATE_XOr()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.DEFLATE(), new XOr()));
    }

    @Test
    public void verifyCRC32_DEFLATE_Hash()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.DEFLATE(), new Hash()));
    }

    @Test
    public void verifyCRC32_Huffman_ConstHeader()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Huffman(), new ConstHeader()));
    }

    @Test
    public void verifyCRC32_Huffman_Checksum()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Huffman(), new Checksum()));
    }

    @Test
    public void verifyCRC32_Huffman_CRC8()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Huffman(), new CRC8()));
    }

    @Test
    public void verifyCRC32_Huffman_CRC16()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Huffman(), new CRC16()));
    }

    @Test
    public void verifyCRC32_Huffman_CRC32()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Huffman(), new CRC32()));
    }

    @Test
    public void verifyCRC32_Huffman_CRC64()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Huffman(), new CRC64()));
    }

    @Test
    public void verifyCRC32_Huffman_XOr()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Huffman(), new XOr()));
    }

    @Test
    public void verifyCRC32_Huffman_Hash()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Huffman(), new Hash()));
    }

    @Test
    public void verifyCRC32_Arithmetic_ConstHeader()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Arithmetic(), new ConstHeader()));
    }

    @Test
    public void verifyCRC32_Arithmetic_Checksum()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Arithmetic(), new Checksum()));
    }

    @Test
    public void verifyCRC32_Arithmetic_CRC8()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Arithmetic(), new CRC8()));
    }

    @Test
    public void verifyCRC32_Arithmetic_CRC16()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Arithmetic(), new CRC16()));
    }

    @Test
    public void verifyCRC32_Arithmetic_CRC32()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Arithmetic(), new CRC32()));
    }

    @Test
    public void verifyCRC32_Arithmetic_CRC64()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Arithmetic(), new CRC64()));
    }

    @Test
    public void verifyCRC32_Arithmetic_XOr()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Arithmetic(), new XOr()));
    }

    @Test
    public void verifyCRC32_Arithmetic_Hash()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.Arithmetic(), new Hash()));
    }

    @Test
    public void verifyCRC32_JPEG_ConstHeader()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.JPEG(), new ConstHeader()));
    }

    @Test
    public void verifyCRC32_JPEG_Checksum()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.JPEG(), new Checksum()));
    }

    @Test
    public void verifyCRC32_JPEG_CRC8()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.JPEG(), new CRC8()));
    }

    @Test
    public void verifyCRC32_JPEG_CRC16()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.JPEG(), new CRC16()));
    }

    @Test
    public void verifyCRC32_JPEG_CRC32()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.JPEG(), new CRC32()));
    }

    @Test
    public void verifyCRC32_JPEG_CRC64()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.JPEG(), new CRC64()));
    }

    @Test
    public void verifyCRC32_JPEG_XOr()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.JPEG(), new XOr()));
    }

    @Test
    public void verifyCRC32_JPEG_Hash()
    {
        verifyResult(buildPacker(new CRC32(), new PacketBuilder.Compressor.JPEG(), new Hash()));
    }

    @Test
    public void verifyCRC64_RSA_ConstHeader()
    {
        verifyResult(buildPacker(new CRC64(), new RSA(), new ConstHeader()));
    }

    @Test
    public void verifyCRC64_RSA_Checksum()
    {
        verifyResult(buildPacker(new CRC64(), new RSA(), new Checksum()));
    }

    @Test
    public void verifyCRC64_RSA_CRC8()
    {
        verifyResult(buildPacker(new CRC64(), new RSA(), new CRC8()));
    }

    @Test
    public void verifyCRC64_RSA_CRC16()
    {
        verifyResult(buildPacker(new CRC64(), new RSA(), new CRC16()));
    }

    @Test
    public void verifyCRC64_RSA_CRC32()
    {
        verifyResult(buildPacker(new CRC64(), new RSA(), new CRC32()));
    }

    @Test
    public void verifyCRC64_RSA_CRC64()
    {
        verifyResult(buildPacker(new CRC64(), new RSA(), new CRC64()));
    }

    @Test
    public void verifyCRC64_RSA_XOr()
    {
        verifyResult(buildPacker(new CRC64(), new RSA(), new XOr()));
    }

    @Test
    public void verifyCRC64_RSA_Hash()
    {
        verifyResult(buildPacker(new CRC64(), new RSA(), new Hash()));
    }

    @Test
    public void verifyCRC64_AES_ConstHeader()
    {
        verifyResult(buildPacker(new CRC64(), new AES(), new ConstHeader()));
    }

    @Test
    public void verifyCRC64_AES_Checksum()
    {
        verifyResult(buildPacker(new CRC64(), new AES(), new Checksum()));
    }

    @Test
    public void verifyCRC64_AES_CRC8()
    {
        verifyResult(buildPacker(new CRC64(), new AES(), new CRC8()));
    }

    @Test
    public void verifyCRC64_AES_CRC16()
    {
        verifyResult(buildPacker(new CRC64(), new AES(), new CRC16()));
    }

    @Test
    public void verifyCRC64_AES_CRC32()
    {
        verifyResult(buildPacker(new CRC64(), new AES(), new CRC32()));
    }

    @Test
    public void verifyCRC64_AES_CRC64()
    {
        verifyResult(buildPacker(new CRC64(), new AES(), new CRC64()));
    }

    @Test
    public void verifyCRC64_AES_XOr()
    {
        verifyResult(buildPacker(new CRC64(), new AES(), new XOr()));
    }

    @Test
    public void verifyCRC64_AES_Hash()
    {
        verifyResult(buildPacker(new CRC64(), new AES(), new Hash()));
    }

    @Test
    public void verifyCRC64_DES_ConstHeader()
    {
        verifyResult(buildPacker(new CRC64(), new DES(), new ConstHeader()));
    }

    @Test
    public void verifyCRC64_DES_Checksum()
    {
        verifyResult(buildPacker(new CRC64(), new DES(), new Checksum()));
    }

    @Test
    public void verifyCRC64_DES_CRC8()
    {
        verifyResult(buildPacker(new CRC64(), new DES(), new CRC8()));
    }

    @Test
    public void verifyCRC64_DES_CRC16()
    {
        verifyResult(buildPacker(new CRC64(), new DES(), new CRC16()));
    }

    @Test
    public void verifyCRC64_DES_CRC32()
    {
        verifyResult(buildPacker(new CRC64(), new DES(), new CRC32()));
    }

    @Test
    public void verifyCRC64_DES_CRC64()
    {
        verifyResult(buildPacker(new CRC64(), new DES(), new CRC64()));
    }

    @Test
    public void verifyCRC64_DES_XOr()
    {
        verifyResult(buildPacker(new CRC64(), new DES(), new XOr()));
    }

    @Test
    public void verifyCRC64_DES_Hash()
    {
        verifyResult(buildPacker(new CRC64(), new DES(), new Hash()));
    }

    @Test
    public void verifyCRC64_TwoFish_ConstHeader()
    {
        verifyResult(buildPacker(new CRC64(), new TwoFish(), new ConstHeader()));
    }

    @Test
    public void verifyCRC64_TwoFish_Checksum()
    {
        verifyResult(buildPacker(new CRC64(), new TwoFish(), new Checksum()));
    }

    @Test
    public void verifyCRC64_TwoFish_CRC8()
    {
        verifyResult(buildPacker(new CRC64(), new TwoFish(), new CRC8()));
    }

    @Test
    public void verifyCRC64_TwoFish_CRC16()
    {
        verifyResult(buildPacker(new CRC64(), new TwoFish(), new CRC16()));
    }

    @Test
    public void verifyCRC64_TwoFish_CRC32()
    {
        verifyResult(buildPacker(new CRC64(), new TwoFish(), new CRC32()));
    }

    @Test
    public void verifyCRC64_TwoFish_CRC64()
    {
        verifyResult(buildPacker(new CRC64(), new TwoFish(), new CRC64()));
    }

    @Test
    public void verifyCRC64_TwoFish_XOr()
    {
        verifyResult(buildPacker(new CRC64(), new TwoFish(), new XOr()));
    }

    @Test
    public void verifyCRC64_TwoFish_Hash()
    {
        verifyResult(buildPacker(new CRC64(), new TwoFish(), new Hash()));
    }

    @Test
    public void verifyCRC64_DEFLATE_ConstHeader()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.DEFLATE(), new ConstHeader()));
    }

    @Test
    public void verifyCRC64_DEFLATE_Checksum()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.DEFLATE(), new Checksum()));
    }

    @Test
    public void verifyCRC64_DEFLATE_CRC8()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.DEFLATE(), new CRC8()));
    }

    @Test
    public void verifyCRC64_DEFLATE_CRC16()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.DEFLATE(), new CRC16()));
    }

    @Test
    public void verifyCRC64_DEFLATE_CRC32()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.DEFLATE(), new CRC32()));
    }

    @Test
    public void verifyCRC64_DEFLATE_CRC64()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.DEFLATE(), new CRC64()));
    }

    @Test
    public void verifyCRC64_DEFLATE_XOr()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.DEFLATE(), new XOr()));
    }

    @Test
    public void verifyCRC64_DEFLATE_Hash()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.DEFLATE(), new Hash()));
    }

    @Test
    public void verifyCRC64_Huffman_ConstHeader()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Huffman(), new ConstHeader()));
    }

    @Test
    public void verifyCRC64_Huffman_Checksum()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Huffman(), new Checksum()));
    }

    @Test
    public void verifyCRC64_Huffman_CRC8()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Huffman(), new CRC8()));
    }

    @Test
    public void verifyCRC64_Huffman_CRC16()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Huffman(), new CRC16()));
    }

    @Test
    public void verifyCRC64_Huffman_CRC32()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Huffman(), new CRC32()));
    }

    @Test
    public void verifyCRC64_Huffman_CRC64()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Huffman(), new CRC64()));
    }

    @Test
    public void verifyCRC64_Huffman_XOr()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Huffman(), new XOr()));
    }

    @Test
    public void verifyCRC64_Huffman_Hash()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Huffman(), new Hash()));
    }

    @Test
    public void verifyCRC64_Arithmetic_ConstHeader()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Arithmetic(), new ConstHeader()));
    }

    @Test
    public void verifyCRC64_Arithmetic_Checksum()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Arithmetic(), new Checksum()));
    }

    @Test
    public void verifyCRC64_Arithmetic_CRC8()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Arithmetic(), new CRC8()));
    }

    @Test
    public void verifyCRC64_Arithmetic_CRC16()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Arithmetic(), new CRC16()));
    }

    @Test
    public void verifyCRC64_Arithmetic_CRC32()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Arithmetic(), new CRC32()));
    }

    @Test
    public void verifyCRC64_Arithmetic_CRC64()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Arithmetic(), new CRC64()));
    }

    @Test
    public void verifyCRC64_Arithmetic_XOr()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Arithmetic(), new XOr()));
    }

    @Test
    public void verifyCRC64_Arithmetic_Hash()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.Arithmetic(), new Hash()));
    }

    @Test
    public void verifyCRC64_JPEG_ConstHeader()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.JPEG(), new ConstHeader()));
    }

    @Test
    public void verifyCRC64_JPEG_Checksum()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.JPEG(), new Checksum()));
    }

    @Test
    public void verifyCRC64_JPEG_CRC8()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.JPEG(), new CRC8()));
    }

    @Test
    public void verifyCRC64_JPEG_CRC16()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.JPEG(), new CRC16()));
    }

    @Test
    public void verifyCRC64_JPEG_CRC32()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.JPEG(), new CRC32()));
    }

    @Test
    public void verifyCRC64_JPEG_CRC64()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.JPEG(), new CRC64()));
    }

    @Test
    public void verifyCRC64_JPEG_XOr()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.JPEG(), new XOr()));
    }

    @Test
    public void verifyCRC64_JPEG_Hash()
    {
        verifyResult(buildPacker(new CRC64(), new PacketBuilder.Compressor.JPEG(), new Hash()));
    }

    @Test
    public void verifyXOr_RSA_ConstHeader()
    {
        verifyResult(buildPacker(new XOr(), new RSA(), new ConstHeader()));
    }

    @Test
    public void verifyXOr_RSA_Checksum()
    {
        verifyResult(buildPacker(new XOr(), new RSA(), new Checksum()));
    }

    @Test
    public void verifyXOr_RSA_CRC8()
    {
        verifyResult(buildPacker(new XOr(), new RSA(), new CRC8()));
    }

    @Test
    public void verifyXOr_RSA_CRC16()
    {
        verifyResult(buildPacker(new XOr(), new RSA(), new CRC16()));
    }

    @Test
    public void verifyXOr_RSA_CRC32()
    {
        verifyResult(buildPacker(new XOr(), new RSA(), new CRC32()));
    }

    @Test
    public void verifyXOr_RSA_CRC64()
    {
        verifyResult(buildPacker(new XOr(), new RSA(), new CRC64()));
    }

    @Test
    public void verifyXOr_RSA_XOr()
    {
        verifyResult(buildPacker(new XOr(), new RSA(), new XOr()));
    }

    @Test
    public void verifyXOr_RSA_Hash()
    {
        verifyResult(buildPacker(new XOr(), new RSA(), new Hash()));
    }

    @Test
    public void verifyXOr_AES_ConstHeader()
    {
        verifyResult(buildPacker(new XOr(), new AES(), new ConstHeader()));
    }

    @Test
    public void verifyXOr_AES_Checksum()
    {
        verifyResult(buildPacker(new XOr(), new AES(), new Checksum()));
    }

    @Test
    public void verifyXOr_AES_CRC8()
    {
        verifyResult(buildPacker(new XOr(), new AES(), new CRC8()));
    }

    @Test
    public void verifyXOr_AES_CRC16()
    {
        verifyResult(buildPacker(new XOr(), new AES(), new CRC16()));
    }

    @Test
    public void verifyXOr_AES_CRC32()
    {
        verifyResult(buildPacker(new XOr(), new AES(), new CRC32()));
    }

    @Test
    public void verifyXOr_AES_CRC64()
    {
        verifyResult(buildPacker(new XOr(), new AES(), new CRC64()));
    }

    @Test
    public void verifyXOr_AES_XOr()
    {
        verifyResult(buildPacker(new XOr(), new AES(), new XOr()));
    }

    @Test
    public void verifyXOr_AES_Hash()
    {
        verifyResult(buildPacker(new XOr(), new AES(), new Hash()));
    }

    @Test
    public void verifyXOr_DES_ConstHeader()
    {
        verifyResult(buildPacker(new XOr(), new DES(), new ConstHeader()));
    }

    @Test
    public void verifyXOr_DES_Checksum()
    {
        verifyResult(buildPacker(new XOr(), new DES(), new Checksum()));
    }

    @Test
    public void verifyXOr_DES_CRC8()
    {
        verifyResult(buildPacker(new XOr(), new DES(), new CRC8()));
    }

    @Test
    public void verifyXOr_DES_CRC16()
    {
        verifyResult(buildPacker(new XOr(), new DES(), new CRC16()));
    }

    @Test
    public void verifyXOr_DES_CRC32()
    {
        verifyResult(buildPacker(new XOr(), new DES(), new CRC32()));
    }

    @Test
    public void verifyXOr_DES_CRC64()
    {
        verifyResult(buildPacker(new XOr(), new DES(), new CRC64()));
    }

    @Test
    public void verifyXOr_DES_XOr()
    {
        verifyResult(buildPacker(new XOr(), new DES(), new XOr()));
    }

    @Test
    public void verifyXOr_DES_Hash()
    {
        verifyResult(buildPacker(new XOr(), new DES(), new Hash()));
    }

    @Test
    public void verifyXOr_TwoFish_ConstHeader()
    {
        verifyResult(buildPacker(new XOr(), new TwoFish(), new ConstHeader()));
    }

    @Test
    public void verifyXOr_TwoFish_Checksum()
    {
        verifyResult(buildPacker(new XOr(), new TwoFish(), new Checksum()));
    }

    @Test
    public void verifyXOr_TwoFish_CRC8()
    {
        verifyResult(buildPacker(new XOr(), new TwoFish(), new CRC8()));
    }

    @Test
    public void verifyXOr_TwoFish_CRC16()
    {
        verifyResult(buildPacker(new XOr(), new TwoFish(), new CRC16()));
    }

    @Test
    public void verifyXOr_TwoFish_CRC32()
    {
        verifyResult(buildPacker(new XOr(), new TwoFish(), new CRC32()));
    }

    @Test
    public void verifyXOr_TwoFish_CRC64()
    {
        verifyResult(buildPacker(new XOr(), new TwoFish(), new CRC64()));
    }

    @Test
    public void verifyXOr_TwoFish_XOr()
    {
        verifyResult(buildPacker(new XOr(), new TwoFish(), new XOr()));
    }

    @Test
    public void verifyXOr_TwoFish_Hash()
    {
        verifyResult(buildPacker(new XOr(), new TwoFish(), new Hash()));
    }

    @Test
    public void verifyXOr_DEFLATE_ConstHeader()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.DEFLATE(), new ConstHeader()));
    }

    @Test
    public void verifyXOr_DEFLATE_Checksum()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.DEFLATE(), new Checksum()));
    }

    @Test
    public void verifyXOr_DEFLATE_CRC8()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.DEFLATE(), new CRC8()));
    }

    @Test
    public void verifyXOr_DEFLATE_CRC16()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.DEFLATE(), new CRC16()));
    }

    @Test
    public void verifyXOr_DEFLATE_CRC32()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.DEFLATE(), new CRC32()));
    }

    @Test
    public void verifyXOr_DEFLATE_CRC64()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.DEFLATE(), new CRC64()));
    }

    @Test
    public void verifyXOr_DEFLATE_XOr()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.DEFLATE(), new XOr()));
    }

    @Test
    public void verifyXOr_DEFLATE_Hash()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.DEFLATE(), new Hash()));
    }

    @Test
    public void verifyXOr_Huffman_ConstHeader()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Huffman(), new ConstHeader()));
    }

    @Test
    public void verifyXOr_Huffman_Checksum()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Huffman(), new Checksum()));
    }

    @Test
    public void verifyXOr_Huffman_CRC8()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Huffman(), new CRC8()));
    }

    @Test
    public void verifyXOr_Huffman_CRC16()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Huffman(), new CRC16()));
    }

    @Test
    public void verifyXOr_Huffman_CRC32()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Huffman(), new CRC32()));
    }

    @Test
    public void verifyXOr_Huffman_CRC64()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Huffman(), new CRC64()));
    }

    @Test
    public void verifyXOr_Huffman_XOr()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Huffman(), new XOr()));
    }

    @Test
    public void verifyXOr_Huffman_Hash()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Huffman(), new Hash()));
    }

    @Test
    public void verifyXOr_Arithmetic_ConstHeader()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Arithmetic(), new ConstHeader()));
    }

    @Test
    public void verifyXOr_Arithmetic_Checksum()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Arithmetic(), new Checksum()));
    }

    @Test
    public void verifyXOr_Arithmetic_CRC8()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Arithmetic(), new CRC8()));
    }

    @Test
    public void verifyXOr_Arithmetic_CRC16()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Arithmetic(), new CRC16()));
    }

    @Test
    public void verifyXOr_Arithmetic_CRC32()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Arithmetic(), new CRC32()));
    }

    @Test
    public void verifyXOr_Arithmetic_CRC64()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Arithmetic(), new CRC64()));
    }

    @Test
    public void verifyXOr_Arithmetic_XOr()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Arithmetic(), new XOr()));
    }

    @Test
    public void verifyXOr_Arithmetic_Hash()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.Arithmetic(), new Hash()));
    }

    @Test
    public void verifyXOr_JPEG_ConstHeader()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.JPEG(), new ConstHeader()));
    }

    @Test
    public void verifyXOr_JPEG_Checksum()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.JPEG(), new Checksum()));
    }

    @Test
    public void verifyXOr_JPEG_CRC8()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.JPEG(), new CRC8()));
    }

    @Test
    public void verifyXOr_JPEG_CRC16()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.JPEG(), new CRC16()));
    }

    @Test
    public void verifyXOr_JPEG_CRC32()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.JPEG(), new CRC32()));
    }

    @Test
    public void verifyXOr_JPEG_CRC64()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.JPEG(), new CRC64()));
    }

    @Test
    public void verifyXOr_JPEG_XOr()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.JPEG(), new XOr()));
    }

    @Test
    public void verifyXOr_JPEG_Hash()
    {
        verifyResult(buildPacker(new XOr(), new PacketBuilder.Compressor.JPEG(), new Hash()));
    }

    @Test
    public void verifyHash_RSA_ConstHeader()
    {
        verifyResult(buildPacker(new Hash(), new RSA(), new ConstHeader()));
    }

    @Test
    public void verifyHash_RSA_Checksum()
    {
        verifyResult(buildPacker(new Hash(), new RSA(), new Checksum()));
    }

    @Test
    public void verifyHash_RSA_CRC8()
    {
        verifyResult(buildPacker(new Hash(), new RSA(), new CRC8()));
    }

    @Test
    public void verifyHash_RSA_CRC16()
    {
        verifyResult(buildPacker(new Hash(), new RSA(), new CRC16()));
    }

    @Test
    public void verifyHash_RSA_CRC32()
    {
        verifyResult(buildPacker(new Hash(), new RSA(), new CRC32()));
    }

    @Test
    public void verifyHash_RSA_CRC64()
    {
        verifyResult(buildPacker(new Hash(), new RSA(), new CRC64()));
    }

    @Test
    public void verifyHash_RSA_XOr()
    {
        verifyResult(buildPacker(new Hash(), new RSA(), new XOr()));
    }

    @Test
    public void verifyHash_RSA_Hash()
    {
        verifyResult(buildPacker(new Hash(), new RSA(), new Hash()));
    }

    @Test
    public void verifyHash_AES_ConstHeader()
    {
        verifyResult(buildPacker(new Hash(), new AES(), new ConstHeader()));
    }

    @Test
    public void verifyHash_AES_Checksum()
    {
        verifyResult(buildPacker(new Hash(), new AES(), new Checksum()));
    }

    @Test
    public void verifyHash_AES_CRC8()
    {
        verifyResult(buildPacker(new Hash(), new AES(), new CRC8()));
    }

    @Test
    public void verifyHash_AES_CRC16()
    {
        verifyResult(buildPacker(new Hash(), new AES(), new CRC16()));
    }

    @Test
    public void verifyHash_AES_CRC32()
    {
        verifyResult(buildPacker(new Hash(), new AES(), new CRC32()));
    }

    @Test
    public void verifyHash_AES_CRC64()
    {
        verifyResult(buildPacker(new Hash(), new AES(), new CRC64()));
    }

    @Test
    public void verifyHash_AES_XOr()
    {
        verifyResult(buildPacker(new Hash(), new AES(), new XOr()));
    }

    @Test
    public void verifyHash_AES_Hash()
    {
        verifyResult(buildPacker(new Hash(), new AES(), new Hash()));
    }

    @Test
    public void verifyHash_DES_ConstHeader()
    {
        verifyResult(buildPacker(new Hash(), new DES(), new ConstHeader()));
    }

    @Test
    public void verifyHash_DES_Checksum()
    {
        verifyResult(buildPacker(new Hash(), new DES(), new Checksum()));
    }

    @Test
    public void verifyHash_DES_CRC8()
    {
        verifyResult(buildPacker(new Hash(), new DES(), new CRC8()));
    }

    @Test
    public void verifyHash_DES_CRC16()
    {
        verifyResult(buildPacker(new Hash(), new DES(), new CRC16()));
    }

    @Test
    public void verifyHash_DES_CRC32()
    {
        verifyResult(buildPacker(new Hash(), new DES(), new CRC32()));
    }

    @Test
    public void verifyHash_DES_CRC64()
    {
        verifyResult(buildPacker(new Hash(), new DES(), new CRC64()));
    }

    @Test
    public void verifyHash_DES_XOr()
    {
        verifyResult(buildPacker(new Hash(), new DES(), new XOr()));
    }

    @Test
    public void verifyHash_DES_Hash()
    {
        verifyResult(buildPacker(new Hash(), new DES(), new Hash()));
    }

    @Test
    public void verifyHash_TwoFish_ConstHeader()
    {
        verifyResult(buildPacker(new Hash(), new TwoFish(), new ConstHeader()));
    }

    @Test
    public void verifyHash_TwoFish_Checksum()
    {
        verifyResult(buildPacker(new Hash(), new TwoFish(), new Checksum()));
    }

    @Test
    public void verifyHash_TwoFish_CRC8()
    {
        verifyResult(buildPacker(new Hash(), new TwoFish(), new CRC8()));
    }

    @Test
    public void verifyHash_TwoFish_CRC16()
    {
        verifyResult(buildPacker(new Hash(), new TwoFish(), new CRC16()));
    }

    @Test
    public void verifyHash_TwoFish_CRC32()
    {
        verifyResult(buildPacker(new Hash(), new TwoFish(), new CRC32()));
    }

    @Test
    public void verifyHash_TwoFish_CRC64()
    {
        verifyResult(buildPacker(new Hash(), new TwoFish(), new CRC64()));
    }

    @Test
    public void verifyHash_TwoFish_XOr()
    {
        verifyResult(buildPacker(new Hash(), new TwoFish(), new XOr()));
    }

    @Test
    public void verifyHash_TwoFish_Hash()
    {
        verifyResult(buildPacker(new Hash(), new TwoFish(), new Hash()));
    }

    @Test
    public void verifyHash_DEFLATE_ConstHeader()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.DEFLATE(), new ConstHeader()));
    }

    @Test
    public void verifyHash_DEFLATE_Checksum()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.DEFLATE(), new Checksum()));
    }

    @Test
    public void verifyHash_DEFLATE_CRC8()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.DEFLATE(), new CRC8()));
    }

    @Test
    public void verifyHash_DEFLATE_CRC16()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.DEFLATE(), new CRC16()));
    }

    @Test
    public void verifyHash_DEFLATE_CRC32()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.DEFLATE(), new CRC32()));
    }

    @Test
    public void verifyHash_DEFLATE_CRC64()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.DEFLATE(), new CRC64()));
    }

    @Test
    public void verifyHash_DEFLATE_XOr()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.DEFLATE(), new XOr()));
    }

    @Test
    public void verifyHash_DEFLATE_Hash()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.DEFLATE(), new Hash()));
    }

    @Test
    public void verifyHash_Huffman_ConstHeader()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Huffman(), new ConstHeader()));
    }

    @Test
    public void verifyHash_Huffman_Checksum()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Huffman(), new Checksum()));
    }

    @Test
    public void verifyHash_Huffman_CRC8()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Huffman(), new CRC8()));
    }

    @Test
    public void verifyHash_Huffman_CRC16()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Huffman(), new CRC16()));
    }

    @Test
    public void verifyHash_Huffman_CRC32()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Huffman(), new CRC32()));
    }

    @Test
    public void verifyHash_Huffman_CRC64()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Huffman(), new CRC64()));
    }

    @Test
    public void verifyHash_Huffman_XOr()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Huffman(), new XOr()));
    }

    @Test
    public void verifyHash_Huffman_Hash()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Huffman(), new Hash()));
    }

    @Test
    public void verifyHash_Arithmetic_ConstHeader()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Arithmetic(), new ConstHeader()));
    }

    @Test
    public void verifyHash_Arithmetic_Checksum()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Arithmetic(), new Checksum()));
    }

    @Test
    public void verifyHash_Arithmetic_CRC8()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Arithmetic(), new CRC8()));
    }

    @Test
    public void verifyHash_Arithmetic_CRC16()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Arithmetic(), new CRC16()));
    }

    @Test
    public void verifyHash_Arithmetic_CRC32()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Arithmetic(), new CRC32()));
    }

    @Test
    public void verifyHash_Arithmetic_CRC64()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Arithmetic(), new CRC64()));
    }

    @Test
    public void verifyHash_Arithmetic_XOr()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Arithmetic(), new XOr()));
    }

    @Test
    public void verifyHash_Arithmetic_Hash()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.Arithmetic(), new Hash()));
    }

    @Test
    public void verifyHash_JPEG_ConstHeader()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.JPEG(), new ConstHeader()));
    }

    @Test
    public void verifyHash_JPEG_Checksum()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.JPEG(), new Checksum()));
    }

    @Test
    public void verifyHash_JPEG_CRC8()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.JPEG(), new CRC8()));
    }

    @Test
    public void verifyHash_JPEG_CRC16()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.JPEG(), new CRC16()));
    }

    @Test
    public void verifyHash_JPEG_CRC32()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.JPEG(), new CRC32()));
    }

    @Test
    public void verifyHash_JPEG_CRC64()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.JPEG(), new CRC64()));
    }

    @Test
    public void verifyHash_JPEG_XOr()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.JPEG(), new XOr()));
    }

    @Test
    public void verifyHash_JPEG_Hash()
    {
        verifyResult(buildPacker(new Hash(), new PacketBuilder.Compressor.JPEG(), new Hash()));
    }

}
