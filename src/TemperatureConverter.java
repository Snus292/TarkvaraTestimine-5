//Дано значение температуры T в градусах Цельсия. 
//Определить значение этой же температуры в градусах Фаренгейта. 
//Температура по Цельсию TC и температура по Фаренгейту TF 
//связаны следующим соотношением: TC = (TF – 32)·5/9. 


public class TemperatureConverter {
    public static double celsToFahr(double cels) {
        double result = (cels * 9/5) + 32;
        System.out.println(result);
        return result;
        
        
    }
    
}
