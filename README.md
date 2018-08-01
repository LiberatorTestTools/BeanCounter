# BeanCounter

## Using the Stopwatch
A quick stopwatch library intended for use in Java testing at Unit and Component test levels.

The stopwatch is created by instantiating the Stopwatch class, e.g.:
```
Stopwatch _watch = new Stopwatch()
```
Each timable interation can use the same stopwatch, as it compiles and aggregate of expended times. To start a timing, use:
```
_watch.Start()
```
Then to stop that timer and add the recorded time to the aggregate, use:
```
_watch.Stop()
```
In some cases, it is important to avoid the timing of certain parts of a test. This can be achieved by using Pause & Restart:
```
_watch.Pause()
_watch.Restart()
```

## Using the Statistics
The BeanCounter has a statistical analysis class, which allows a quick analysis of the timings retrieved during the process under investigation. It contains the following functionality:
```
_watch.ArithmeticMean()
_watch.GeometricMean()
_watch.QuadraticMean()
_watch.Kurtosis()
_watch.Max()
_watch.Min()
_watch.Mode()
_watch.N()
_watch.PopulationVariance()
_watch.Skewness()
_watch.StandardDeviation()
_watch.Sum()
_watch.SumSquares()
_watch.Variance()
```

The most used calls in performance testing will be:
```
_watch.ArithmeticMean()
_watch.StandardDeviation()
_watch.Max()
_watch.Min()
```
