package com.freight.crm.dao;

import java.util.List;

import com.freight.crm.entity.PickDrop;

public interface IPickDropDAO {
	
	List<PickDrop> getAllPickDrop();
	PickDrop getPickDropById(int pickDropId);
    void addAPickDrop(PickDrop pickDrop);
    void updatePickDrop(PickDrop pickDrop);
    void deletePickDrop(int pickDropId);

}
