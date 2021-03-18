/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kaki.aria.service;

import com.kaki.aria.model.Document;
import com.kaki.aria.repository.DocumentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jose
 */
@Service("documentService")
public class DocumentService {
    
    DocumentRepository documentRepo;
    
    public Document findById(long documentId) {
        return documentRepo.findById(documentId);
    }
    
    public List<Document> findAll() {
        return documentRepo.findAll();
    }
    
    public void deleteById(long documentId) {
        documentRepo.deleteById(documentId);
    }
    
    public Document saveDocument(Document document) {
        return documentRepo.saveDocument(document);
    }
    
}
