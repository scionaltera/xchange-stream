package info.bitrich.xchangestream.bitfinex;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BitfinexStreamingServiceTest {
    private String apiUrl = "https://the.bitfinex.stream.url";
    private String arg1 = "arg1";

    private BitfinexStreamingService bitfinexStreamingService;

    @Before
    public void setUp() {
        bitfinexStreamingService = new BitfinexStreamingService(apiUrl);
    }

    @Test
    public void testSubscribeMessageDoesNotHaveACurrencyPair() throws IOException {
        String result = bitfinexStreamingService.getSubscribeMessage("ticker-BTCUSD", arg1);

        assertTrue(result.contains("arg1"));
        assertTrue(result.contains("ticker"));
        assertFalse(result.contains("BTCUSD"));
    }
}
