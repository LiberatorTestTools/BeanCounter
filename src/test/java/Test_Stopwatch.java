import org.junit.Assert;
import org.junit.Test;

public class Test_Stopwatch {

    @Test
    public void Test_Timer_Start() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        long _time = _stopwatch.get_startTime();
        Assert.assertTrue(_time > 0);
    }

    @Test
    public void Test_Timer_Pause() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Pause();
        long _time = _stopwatch.get_timer().get_duration();
        Assert.assertTrue(_time > 0);
    }

    @Test
    public void Test_Timer_StartStop() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        long _time = _stopwatch.get_timer().get_duration();
        Assert.assertTrue(_time > 0);
    }

    @Test
    public void Test_Timer_StartStopTime() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        Assert.assertTrue(_stopwatch.get_endTime() > _stopwatch.get_startTime());
    }

    @Test
    public void Test_Timer_LastTime() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        Assert.assertTrue(_stopwatch.get_lastTime() > _stopwatch.get_startTime());
    }

    @Test
    public void Test_Timer_Count() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        int _timers = _stopwatch.get_aggregate().size();
        Assert.assertEquals(1, _timers);
    }

    @Test
    public void Test_Timer_TwoTimings() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        int _timers = _stopwatch.get_aggregate().size();
        Assert.assertEquals(2, _timers);
    }

    @Test
    public void Test_Timer_TwoTimingsRemoveOne() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        _stopwatch.RemoveTimer(0);
        int _timers = _stopwatch.get_aggregate().size();
        Assert.assertEquals(1, _timers);
    }

    @Test
    public void Test_Timer_TwoTimingsRemoveLast() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Stop();
        _stopwatch.RemoveTimer(1);
        int _timers = _stopwatch.get_aggregate().size();
        Assert.assertEquals(1, _timers);
    }

    @Test
    public void Test_Timer_Restart() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Pause();
        Thread.sleep(1);
        _stopwatch.Restart();
        long _time = _stopwatch.get_timer().get_duration();
        Assert.assertTrue(_time > 0);
    }

    @Test
    public void Test_Timer_DoublePausedTiming() throws InterruptedException {
        Stopwatch _stopwatch = new Stopwatch();
        _stopwatch.Start();
        Thread.sleep(1);
        _stopwatch.Pause();
        Thread.sleep(1);
        _stopwatch.Restart();
        _stopwatch.Pause();
        Thread.sleep(1);
        _stopwatch.Restart();
        Thread.sleep(1);
        _stopwatch.Stop();
        int _times = _stopwatch.get_aggregate().size();
        Assert.assertEquals(1, _times);
    }
}
