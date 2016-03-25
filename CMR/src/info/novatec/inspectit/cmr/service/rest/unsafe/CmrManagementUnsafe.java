package info.novatec.inspectit.cmr.service.rest.unsafe;

import info.novatec.inspectit.cmr.property.configuration.PropertySection;
import info.novatec.inspectit.cmr.property.update.configuration.ConfigurationUpdate;
import info.novatec.inspectit.communication.data.cmr.CmrStatusData;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class CmrManagementUnsafe implements IUnsafeCmrManagementService {
	
	@Autowired
	private IUnsafeEntryForCmrManagement entry;

	@Override
	public void restart() {
		entry.unsafeRestart();
	}
	
	@Override
	public void shutdown() {
		entry.unsafeShutdown();
	}

	@Override
	public void clearBuffer() {
		entry.clearBuffer();
	}

	@Override
	public CmrStatusData getCmrStatusData() {
		return entry.getCmrStatusData();
	}

	@Override
	public void addDroppedDataCount(int count) {
		entry.addDroppedDataCount(count);
	}

	@Override
	public int getDroppedDataCount() {
		return entry.getDroppedDataCount();
	}

	@Override
	public Collection<PropertySection> getConfigurationPropertySections() {
		return entry.getConfigurationPropertySections();
	}

	@Override
	public void updateConfiguration(ConfigurationUpdate configurationUpdate, boolean executeRestart) throws Exception {
		entry.updateConfiguration(configurationUpdate, executeRestart);
	}
}
