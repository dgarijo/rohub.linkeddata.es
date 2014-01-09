/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Copyright 2012-2013 Ontology Engineering Group, Universidad Politécnica de Madrid, Spain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.oeg.rohubweb;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.util.ArrayList;
import org.semarglproject.jena.rdf.rdfa.JenaRdfaReader;

/**
 * Class for parsing Research Objects described in rdf-a from html web pages.
 * @author Daniel Garijo
 */
public class ParseROs {
    /**
     * Method that returns the whole list of Research Objects. The URIs
     * are taken from the Constants file.
     * @return ArrayList with the obtained ROs.
     */
    public ArrayList<RO> getROs(){
        String[] roURLs = Constants.uris;
        ArrayList<RO> ros = new ArrayList<RO>();
        for(int i=0; i<roURLs.length;i++){
            try{
                RO currentRo = this.getRO(roURLs[i]);
                if(currentRo != null){
                    ros.add(currentRo);
                }else{
                    System.out.println("RO skipped: "+roURLs[i]+". No title found");
                }
            }catch(Exception e){
                System.err.println("Error while processing RO: "+roURLs[i]+" "+e.getMessage());
            }            
        }
        return ros;
    }
    /**
     * Given a URL of a Research Object, this method extracts its rdf-a to obtain
     * title and abstract in order to show them on the landing page.
     * @return returns the Research object
     */
    private RO getRO(String roUrl){
        JenaRdfaReader.inject();
        OntModel model = ModelFactory.createOntologyModel();        
        model.read(roUrl, roUrl, "RDFA");
        String query = "select distinct ?roURI ?title ?abstract where {"
                + "?roURI <http://purl.org/dc/terms/title> ?title."
                + "OPTIONAL{?roURI <http://purl.org/dc/terms/abstract> ?abstract}}";
        ResultSet rs = queryLocalRepository(query, model);
        String roURI=roUrl,roAbstract="",roTitle="";
        //we assume one description per RO.
        if (rs.hasNext()){            
            QuerySolution qs = rs.nextSolution();                       
            roTitle = qs.getLiteral("?title").getString();           
            try{
                roAbstract = qs.getLiteral("?abstract").getString();           
            }finally{
                System.out.println(roURI+"\n "+roTitle+"\n "+roAbstract);
                return new RO(roURI, roTitle, roAbstract);
            }
        }
        else return null;
        
    }
    
    private ResultSet queryLocalRepository(String queryIn, OntModel repository){
        Query query = QueryFactory.create(queryIn);
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, repository);
        ResultSet rs =  qe.execSelect();
        //qe.close();
        return rs;
    }
}
