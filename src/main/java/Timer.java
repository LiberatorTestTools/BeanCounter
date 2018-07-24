import java.util.Date;

/**
 * A timer class used in stopwatches
 */
class Timer {

    Timer(){
        _now = SerialTime();
    }

    private long _now;
    private long _startTime;
    private long _endTime;
    private long _duration;
    private boolean _counting = false;
    private boolean _paused;

    /**
     * Gets the duration of the last completed timer
     * @return The duration of the last completed timer
     */
    long get_duration() {
        return _duration;
    }

    long Now() throws StopwatchException {
        try {
            _now = SerialTime();
        } catch (Exception e) {
            _now = 0;
        }
        return _now;
    }

    /**
     * Starts a new timer
     * @return The start time of the new timer
     * @throws StopwatchException An exception indicating an incorrect use of the command
     */
    long Start() throws StopwatchException {
        if (!_counting) {
            try {
                _counting = true;
                _startTime = SerialTime();
                _endTime = 0;
                _duration = 0;
            } catch (Exception e) {
                _startTime = 0;
                _counting = false;
            }
        } else {
            throw new StopwatchException("A stopwatch cannot be started if it is already ticking");
        }
        return _startTime;
    }

    /**
     * Stops a running timer
     * @return The end time of the last timer
     * @throws StopwatchException An exception indicating an incorrect use of the command
     */
    long Stop() throws StopwatchException {
        if (_counting & !_paused) {
            try {
                _endTime = SerialTime();
                _duration = _duration + _endTime - _startTime;
            } catch (Exception e) {
                _endTime = 0;
            }
        }
        else {
            throw new StopwatchException("A stopwatch cannot be stopped if it is not running.");
        }
        _counting = false;
        return _endTime;
    }

    /**
     * Pauses a running timer
     * @return The duration of the last timer
     * @throws StopwatchException An exception indicating an incorrect use of the command
     */
    long Pause() throws StopwatchException {
        if (_counting & !_paused) {
            try {
                _duration = Stop();
                _paused = true;
            } catch (Exception e) {
                _duration = 0;
                _paused = false;
            }
        }
        else {
            throw new StopwatchException("A paused stopwatch cannot be paused without being restarted.");
        }
        _counting = false;
        return _duration;
    }

    /**
     * Restarts a paused timer
     * @return The start time of the current timer
     * @throws StopwatchException An exception indicating an incorrect use of the command
     */
    long Restart() throws StopwatchException {
        if (!_counting & _paused) {
            try {
                _counting = true;
                _endTime = 0;
                _startTime = SerialTime();
                _paused = false;
            } catch (Exception e) {
                _counting = false;
                _startTime = 0;
            }
        }
        else {
            throw new StopwatchException("Stopwatch cannot restart as it is not paused");
        }
        return _startTime;
    }

    /**
     * Returns the current time as a number of milliseconds from UNIX Date
     * @return Number of milliseconds since the Unix Date
     */
    private long SerialTime() {
        Date _date = new Date();
        _now = _date.getTime();
        return _now;
    }
}
