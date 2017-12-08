package com.freight.crm.dao;

import java.util.List;

import com.freight.crm.entity.Load;

public interface ILoadDAO {
	
	List<Load> getAllArticles();
	Load getLoadById(int loadId);
    void addLoad(Load load);
    void updateLoad(Load load);
    void deleteLoad(int loadId);

}
