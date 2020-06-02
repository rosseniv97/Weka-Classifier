/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

import java.util.ArrayList;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author Rossen
 */
public abstract class Classifier {
   // private final static String pathToClassifier = System.getProperty("user.dir") + "\\data\\classifiers\\Nb.model";
    private static enum algorithmNames {
        NAIVEBAYES,
        J48,
        SVM,
        BYESNET  
    };
    private String classificationTask;
    protected Instances dataStructure;
    protected Instance dataToBeClassified;
    private int numClasses;
    protected ArrayList<Attribute> attributesList;
    
    public Classifier(String classificationTask) {
        this.classificationTask = classificationTask;
        try {
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("D:\\2019_ 2020\\Weka API\\"+classificationTask+".arff");
            dataStructure = source.getDataSet();
            dataStructure.setClassIndex(dataStructure.numAttributes() - 1);
            numClasses = dataStructure.numClasses();
            attributesList=new ArrayList();
            dataToBeClassified = new DenseInstance(dataStructure.numAttributes());

            for (int i = 0; i < dataStructure.numAttributes()-1; i++) {
                attributesList.add(dataStructure.attribute(i)); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public abstract String Classify(double[] attributes);
        
    
}
