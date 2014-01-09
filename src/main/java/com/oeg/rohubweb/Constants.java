
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

/**
 * Constants for generating the html plus the URIs of the ROs to be generated.
 * @author Daniel Garijo
 */
public class Constants {
    /**
     * ROs to be parsed. Note that the rdf-a parser is very picky. Unless the html
     * is absolutely correct, it will fail to parse the RO. Use
     * http://validator.w3.org/ to check your web pages before submitting an RO.
     */
    public static final String[] uris={
        "http://rohub.linkeddata.es/motifs_bundle_page-FGCS/index.html",
        //"https://dl.dropboxusercontent.com/u/16510488/index.html",
        "http://rohub.linkeddata.es/drugome_bundle_page-PLOS/index.html",
        "http://rohub.linkeddata.es/ro-svmworkflow/index.html",
        "https://dl.dropboxusercontent.com/u/16510488/Research%20Object%20infrastructures/myResearchObject1389281308762.html"};
}
