import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Test_Statistics {

    Statistics _stats;

    @Before
    public void Test_Stats(){
        _stats = new Statistics();
    }

    @Test
    public void Test_ArithmeticMean(){
        double _mean = _stats.ArithmeticMean(TestArray());
        Assert.assertEquals(2, _mean, 0.0);
    }

    @Test
    public void Test_GeometricMean(){
        double _mean = _stats.GeometricMean(TestArray());
        Assert.assertEquals(1.8612097182041991, _mean, 0.0);
    }

    @Test
    public void Test_QuadraticMean(){
        double _mean = _stats.QuadraticMean(TestArray());
        Assert.assertEquals(2.1213203435596424, _mean, 0.0);
    }

    @Test
    public void Test_Kurtosis(){
        double _kurtosis = _stats.Kurtosis(TestArray());
        Assert.assertEquals(1.5, _kurtosis, 0.0);
    }

    @Test
    public void Test_Max(){
        double _max = _stats.Max(TestArray());
        Assert.assertEquals(3, _max, 0.0);
    }

    @Test
    public void Test_Min(){
        double _min = _stats.Min(TestArray());
        Assert.assertEquals(1, _min, 0.0);
    }

    @Test
    public void Test_Mode(){
        double[] _mode = _stats.Mode(TestArray());
        Assert.assertEquals(1, _mode.length, 0.0);
    }

    @Test
    public void Test_N(){
        double _number = _stats.N(TestArray());
        Assert.assertEquals(4, _number, 0.0);
    }

    @Test
    public void Test_PopulationVariance(){
        double _variance = _stats.PopulationVariance(TestArray());
        Assert.assertEquals(0.5, _variance, 0.0);
    }

    @Test
    public void Test_Skewness(){
        double _skewness = _stats.Skewness(TestArray());
        Assert.assertEquals(0.0, _skewness, 0.0);
    }

    @Test
    public void Test_StandardDeviation(){
        double _skewness = _stats.StandardDeviation(TestArray());
        Assert.assertEquals(0.816496580927726, _skewness, 0.0);
    }

    @Test
    public void Test_Sum(){
        double _sum = _stats.Sum(TestArray());
        Assert.assertEquals(8, _sum, 0.0);
    }

    @Test
    public void Test_Squares(){
        double _sum = _stats.SumSquares(TestArray());
        Assert.assertEquals(18.0, _sum, 0.0);
    }

    @Test
    public void Test_Variance(){
        double _sum = _stats.Variance(TestArray());
        Assert.assertEquals(0.6666666666666666, _sum, 0.0);
    }

    private List<Long> TestArray(){
        List<Long> _list =  new LinkedList<Long>();
        _list.add((long)1);
        _list.add((long)2);
        _list.add((long)2);
        _list.add((long)3);
        return _list;
    }
}
