import org.junit.*;

public class Test_Timer {

    @Test
    public void Test_Timer_Now() throws StopwatchException {
        Timer _timer = new Timer();
        long _microseconds = _timer.Now();
        Assert.assertTrue(_microseconds > 0);
    }

    @Test
    public void Test_Timer_StartStop() throws StopwatchException, InterruptedException {
        Timer _timer = new Timer();
        _timer.Start();
        Thread.sleep(1);
        _timer.Stop();
        long _microseconds = _timer.get_duration();
        Assert.assertTrue(_microseconds > 0);
    }

    @Test
    public void Test_Timer_StartStopValues() throws StopwatchException, InterruptedException {
        Timer _timer = new Timer();
        long _start =_timer.Start();
        Thread.sleep(2);
        long _stop = _timer.Stop();
        long _microseconds = _stop - _start;
        Assert.assertTrue(_microseconds > 1);
    }

    @Test
    public void Test_Timer_StartPause() throws StopwatchException, InterruptedException {
        Timer _timer = new Timer();
        _timer.Start();
        Thread.sleep(1);
        _timer.Pause();
        long _microseconds = _timer.get_duration();
        Assert.assertTrue(_microseconds > 0);
    }

    @Test(expected = StopwatchException.class)
    public void Test_Timer_StartPauseStop() throws StopwatchException, InterruptedException {
        Timer _timer = new Timer();
        _timer.Start();
        Thread.sleep(1);
        _timer.Pause();
        _timer.Stop();
    }


    @Test
    public void Test_Timer_StartPauseRestartStop() throws StopwatchException, InterruptedException {
        Timer _timer = new Timer();
        _timer.Start();
        Thread.sleep(1);
        _timer.Pause();
        Thread.sleep(1);
        _timer.Restart();
        Thread.sleep(1);
        _timer.Stop();
        long _microseconds = _timer.get_duration();
        Assert.assertTrue(_microseconds > 3);
    }


    @Test
    public void Test_Timer_StartPauseRestartStopValues() throws StopwatchException, InterruptedException {
        Timer _timer = new Timer();
        long _start = _timer.Start();
        Thread.sleep(1);
        long _pause = _timer.Pause();
        Thread.sleep(1);
        long _restart = _timer.Restart();
        Thread.sleep(1);
        long _stop = _timer.Stop();
        long _microseconds = (_stop - _restart) + (_pause - _start);
        Assert.assertTrue(_microseconds > 1);
    }



    @Test(expected = StopwatchException.class)
    public void Test_Timer_DoubleStart() throws StopwatchException {
        Timer _timer = new Timer();
        _timer.Start();
        _timer.Start();
    }

    @Test(expected = StopwatchException.class)
    public void Test_Timer_StopNotStarted() throws StopwatchException {
        Timer _timer = new Timer();
        _timer.Stop();
    }

    @Test(expected = StopwatchException.class)
    public void Test_Timer_RestartStopped() throws StopwatchException {
        Timer _timer = new Timer();
        _timer.Start();
        _timer.Stop();
        _timer.Restart();
    }

    @Test(expected = StopwatchException.class)
    public void Test_Timer_RestartNotStarted() throws StopwatchException {
        Timer _timer = new Timer();
        _timer.Restart();
    }

    @Test(expected = StopwatchException.class)
    public void Test_Timer_PauseStopped() throws StopwatchException {
        Timer _timer = new Timer();
        _timer.Start();
        _timer.Stop();
        _timer.Pause();
    }
}
