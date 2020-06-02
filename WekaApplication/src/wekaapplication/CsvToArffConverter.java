/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekaapplication;

/**
 *
 * @author Rossen
 */
import java.io.File;
import weka.core.Instances;
import weka.core.converters.*;


public class CsvToArffConverter {
    public static void main(String[] args) throws Exception {  
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File("D:\\2019_ 2020\\Дипломна работа\\HearthDiseasePrediction\\framingham.csv"));
        Instances data = loader.getDataSet();
        
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File("D:\\2019_ 2020\\Дипломна работа\\HearthDiseasePrediction\\framingham.arff"));
        saver.writeBatch();
    }

}
