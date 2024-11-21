//package Tests;
//
//import mazesolver.GamePanel;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static javax.management.Query.times;
//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class Gamelooptest {
//
//    @Mock
//    private GamePanel gamePanel;  // Assuming this is the class where run() is defined
//
//    @Mock
//    private Thread gameThread;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    // Test for FPS calculations
//    @Test
//    public void testDrawIntervalCalculation() {
//        int FPS = 60; // Assume FPS is 60
//        double expectedDrawInterval = 1000000000.0 / FPS; // 0.016666 seconds
//
//        double drawInterval = 1000000000.0 / FPS;
//
//        // Test if the FPS-based interval is calculated correctly
//        assertEquals(expectedDrawInterval, drawInterval, 0.0000001);
//    }
//
//    // Test for delta accumulation
//    @Test
//    public void testDeltaAccumulation() {
//        long lastTime = 1000000000; // Mocking a specific timestamp
//        long currentTime = lastTime + 500000000; // 0.5 second later
//        double drawInterval = 1000000000.0 / 60.0; // FPS = 60
//        double delta = 0;
//
//        // Simulate the passage of time
//        delta += (currentTime - lastTime) / drawInterval;
//
//        // The expected value of delta should be 0.5 (after 0.5 second)
//        assertEquals(0.5, delta, 0.0000001);
//    }
//
//    // Test for update() and repaint() calls
//    @Test
//    public void testUpdateAndRepaintCalled() {
//        // Set up a mock GamePanel with FPS of 60
//        GamePanel gamePanelMock = mock(GamePanel.class);
//        double drawInterval = 1000000000.0 / 60.0; // FPS = 60
//        double delta = 1.0; // Assuming delta reaches 1 after some time
//
//        // Call the run() method, but simulate the delta threshold logic
//        gamePanelMock.run(); // This will call update() and repaint()
//
//        // Verify if update() and repaint() are called
//        verify(gamePanelMock, times(1)).update();
//        verify(gamePanelMock, times(1)).repaint();
//    }
//
//    // Test for proper time management (multiple iterations)
//    @Test
//    public void testTimeManagement() {
//        GamePanel gamePanelMock = mock(GamePanel.class);
//        long lastTime = 1000000000;
//        long currentTime = lastTime + 160000000; // Simulate 0.16 seconds passing
//        double delta = 0;
//        double drawInterval = 1000000000.0 / 60.0; // FPS = 60
//
//        // Simulate the run() method's loop logic
//        for (int i = 0; i < 3; i++) {
//            delta += (currentTime - lastTime) / drawInterval;
//            if (delta >= 1) {
//                gamePanelMock.update();
//                gamePanelMock.repaint();
//                delta--; // Reset delta
//            }
//        }
//
//        // Verify if update() and repaint() were called 3 times
//        verify(gamePanelMock, times(3)).update();
//        verify(gamePanelMock, times(3)).repaint();
//    }
//}
