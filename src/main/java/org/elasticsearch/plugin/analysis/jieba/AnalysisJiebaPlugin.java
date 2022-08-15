package org.elasticsearch.plugin.analysis.jieba;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.JiebaAnalyzerProvider;
import org.elasticsearch.index.analysis.JiebaTokenizerFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangcheng on 2017/1/17.
 */
public class AnalysisJiebaPlugin extends Plugin implements AnalysisPlugin {

  public static String PLUGIN_NAME = "analysis-jieba";

  @Override
  public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
    Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> extra = new HashMap<>();

    //extra.put("jieba_hk_search", JiebaTokenizerFactory::getJiebaSearchTokenizerFactory);
    extra.put("iieba_hk_search",
            (indexSettings, environment, name, settings) ->
                    JiebaTokenizerFactory.getJiebaSearchTokenizerFactory(indexSettings, environment, name, settings, "hk")
    );
    //extra.put("jieba_hk_index", JiebaTokenizerFactory::getJiebaIndexTokenizerFactory);

    extra.put("iieba_hk_index",
            (indexSettings, environment, name, settings) ->
                    JiebaTokenizerFactory.getJiebaSearchTokenizerFactory(indexSettings, environment, name, settings, "hk")
    );


    /*
    //extra.put("jieba_tw_search", JiebaTokenizerFactory::getJiebaSearchTokenizerFactory, "tw");
    extra.put("iieba_tw_search",
            (indexSettings, environment, name, settings) ->
                    JiebaTokenizerFactory.getJiebaSearchTokenizerFactory(indexSettings, environment, name, settings, "tw")
    );
    //extra.put("jieba_tw_index", JiebaTokenizerFactory::getJiebaIndexTokenizerFactory);
    extra.put("ieba_tw_index",
            (indexSettings, environment, name, settings) ->
                    JiebaTokenizerFactory.getJiebaSearchTokenizerFactory(indexSettings, environment, name, settings, "tw")
    );
    */

    return extra;
  }

  @Override
  public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
    Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> extra = new HashMap<>();

    //extra.put("jieba_hk_search", JiebaAnalyzerProvider::getJiebaSearchAnalyzerProvider);
    extra.put("jieba_hk_search",
            (indexSettings, environment, name, settings) ->
                    JiebaAnalyzerProvider.getJiebaSearchAnalyzerProvider(indexSettings, environment, name, settings, "hk")
    );
    //extra.put("jieba_hk_index", JiebaAnalyzerProvider::getJiebaIndexAnalyzerProvider);
    extra.put("jieba_hk_index",
            (indexSettings, environment, name, settings) ->
                    JiebaAnalyzerProvider.getJiebaSearchAnalyzerProvider(indexSettings, environment, name, settings, "hk")
    );


    //extra.put("jieba_tw_search", JiebaAnalyzerProvider::getJiebaSearchAnalyzerProvider);

    /*
    extra.put("jieba_tw_search",
            (indexSettings, environment, name, settings) ->
                    JiebaAnalyzerProvider.getJiebaSearchAnalyzerProvider(indexSettings, environment, name, settings, "tw")
    );
    //extra.put("jieba_tw_index", JiebaAnalyzerProvider::getJiebaIndexAnalyzerProvider);
    extra.put("jieba_tw_index",
            (indexSettings, environment, name, settings) ->
                    JiebaAnalyzerProvider.getJiebaSearchAnalyzerProvider(indexSettings, environment, name, settings, "tw")
    );
    */


    return extra;
  }
}
