import java.util.ArrayList;
import java.util.List;

class Stopwatch {

    /**
     * Constructor for the class
     */
    Stopwatch(){
        _aggregate = new ArrayList<Long>();
        _timer = new Timer();
        _lastTime = 0;
        _startTime = 0;
        _endTime = 0;
    }

    /**
     * Gets the aggregate set of all timings
     * @return A list of timings
     */
    List<Long> get_aggregate() {
        return _aggregate;
    }

    /**
     * Gets the currently active timer
     * @return
     */
    Timer get_timer() {
        return _timer;
    }

    /**
     * Returns the
     * @return
     */
    long get_lastTime() {
        return _lastTime;
    }

    long get_startTime() {
        return _startTime;
    }

    long get_endTime() {
        return _endTime;
    }

    private List<Long> _aggregate;
    private Timer _timer;
    private long _lastTime;
    private long _startTime;
    private long _endTime;

    void Start(){
        try{
            _timer = new Timer();
            _startTime = _timer.Start();
            _lastTime = _startTime;
        } catch (Exception e){
            _startTime = 0;
        }
    }

    void Pause(){
        try{
            _endTime = _timer.Pause();
            _lastTime = _endTime;
        } catch(Exception e){
            _endTime = 0;
        }
    }

    void Restart(){
        try {
            _startTime = _timer.Restart();
            _lastTime = _startTime;
        } catch (Exception e){
            _startTime = _lastTime;
        }
    }

    void Stop(){
        try {
            _endTime = _timer.Stop();
            _aggregate.add(_timer.get_duration());
            _lastTime = _endTime;
        } catch (Exception e) {
            _endTime = _lastTime;
        }
    }

    void RemoveTimer(int timer){
        try {
            _aggregate.remove(timer);
        } catch (Exception e){
            _lastTime = 0;
        }
    }
}
