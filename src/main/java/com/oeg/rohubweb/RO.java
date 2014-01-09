
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
 *
 * @author Daniel Garijo
 */
public class RO {
    private String title;
    private String abstractSection;
    private String uri;
    //creators ommited since we don't show them on the web page.
    

    public RO(String uri, String title, String abstractSection) {
        this.uri = uri;
        this.title = title;
        this.abstractSection = abstractSection;

    }

    public String getAbstractSection() {
        return abstractSection;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }
    
    
    
}
