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
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.*;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.NonSparseToSparse;
import weka.filters.unsupervised.attribute.Discretize;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.SMO;

public class ClassificationBuilder {

    public static void main(String[] args) throws Exception {

        DataSource source = new DataSource("D:\\2019_ 2020\\Weka API\\iris.arff");
        Instances traindataset = source.getDataSet();
        traindataset.setClassIndex(traindataset.numAttributes() - 1);
        
        String path = System.getProperty("user.dir")+"\\data\\classifiers\\Nb.model";
        File classFile = new File(path);
        classFile.createNewFile();
        
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(traindataset);
        
        SerializationHelper.write(path, nb);

    }

}
