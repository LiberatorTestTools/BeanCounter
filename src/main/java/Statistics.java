import java.util.List;
import org.apache.commons.math3.stat.descriptive.*;
import org.apache.commons.math3.stat.StatUtils;

public class Statistics {

    Statistics(){
        _ds = new DescriptiveStatistics();
    }

    private double _statistic;
    private double[] _statistics;
    private DescriptiveStatistics _ds;

    public double ArithmeticMean(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getMean();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double GeometricMean(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getGeometricMean();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double QuadraticMean(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getQuadraticMean();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double Kurtosis(List<Long> collections){
        try {
            CompileTimings(collections);
            _statistic = _ds.getKurtosis();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double Max(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getMax();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double[] Mode(List<Long> collection){
        try {
            double[] val = Array(collection);
            _statistics = StatUtils.mode(val);
        } catch (Exception e){
            _statistics = new double[] {0};
        }
        return _statistics;
    }

    public double Min(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getMin();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double N(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getN();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double PopulationVariance(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getPopulationVariance();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double Skewness(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getSkewness();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double StandardDeviation(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getStandardDeviation();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double Sum(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getSum();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double SumSquares(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getSumsq();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    public double Variance(List<Long> collection){
        try {
            CompileTimings(collection);
            _statistic = _ds.getVariance();
        } catch (Exception e){
            _statistic = 0;
        }
        return _statistic;
    }

    private void CompileTimings(List<Long> collection){

        for (int i=0;i<collection.size();i++){
            _ds.addValue(collection.get(i));
        }
    }

    private double[] Array(List<Long> collection){
        double[] array = new double[collection.size()];
        for (int i = 0; i < collection.size(); i++){
            array[i] = collection.get(i);
        }
        return array;
    }
}
