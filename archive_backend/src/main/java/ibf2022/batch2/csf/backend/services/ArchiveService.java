package ibf2022.batch2.csf.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.batch2.csf.backend.repositories.ArchiveRepository;

@Service
public class ArchiveService {
    
    @Autowired
    ArchiveRepository arcRepo;

    public Object getBundleByBundleId(String bundleId) {
        return this.arcRepo.getBundleByBundleId(bundleId); 
    }

    public Object getBundles() {
        return this.arcRepo.getBundles();
    }


}
