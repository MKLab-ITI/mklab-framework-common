
package gr.iti.mklab.framework.common.services;

import gr.iti.mklab.framework.common.domain.Item;
import gr.iti.mklab.framework.common.domain.dysco.Dysco;

import java.util.List;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public interface GenericDyscoCreator {
    
    public List<Dysco> createDyscos(List<Item> items);
    
}
