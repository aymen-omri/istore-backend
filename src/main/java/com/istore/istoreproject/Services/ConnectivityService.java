package com.istore.istoreproject.Services;

import com.istore.istoreproject.models.Connectivity;

public interface ConnectivityService {

    Connectivity add(Connectivity connectivity);

    void delete(long id);
}
