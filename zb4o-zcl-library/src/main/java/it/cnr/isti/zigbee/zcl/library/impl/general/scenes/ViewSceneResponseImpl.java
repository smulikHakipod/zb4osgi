/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies 
   of the Italian National Research Council 


   See the NOTICE file distributed with this work for additional 
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package it.cnr.isti.zigbee.zcl.library.impl.general.scenes;

import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.Status;
import it.cnr.isti.zigbee.zcl.library.api.core.ZBDeserializer;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.ExtensionFieldSetViewResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.RemoveSceneResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.ViewSceneResponse;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultDeserializer;
import it.cnr.isti.zigbee.zcl.library.impl.core.ResponseImpl;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class ViewSceneResponseImpl extends ResponseImpl implements
		ViewSceneResponse {
	
	private ExtensionFieldSetViewResponse[] extensionfield;
	private int groupId;
	private short sceneId;
	private String sceneName;
	private byte status;
	private int transitionTime;
	
	public ViewSceneResponseImpl(Response response)throws ZigBeeClusterException{
		super(response);
		ResponseImpl.checkSpecificCommandFrame(response, RemoveSceneResponse.ID);
		ZBDeserializer deserializer = new DefaultDeserializer(getPayload(),0);
		status = deserializer.read_byte();
		groupId = deserializer.read_short();
		sceneId = deserializer.read_byte();
		transitionTime = deserializer.read_short();
		//TODO check variable length
		//TODO use the deserializer.readZigBeeType(ZigBeeType)
		sceneName = (String) deserializer.readObject(String.class); 
		// TODO read extensionFieldSet
		int i = 0; 
		boolean cond = true; //extensionfield end
		while (cond){
			extensionfield[i] = new ExtensionFieldSetViewResponseImpl(deserializer);
			i= i + 1;
			cond = extensionfield[i].endSet();
		}
	}

	public ExtensionFieldSetViewResponse[] getExstensionFieldSet() {
		return extensionfield;
	}

	public int getGroupId() {
		return groupId;
	}

	public short getSceneId() {
		return sceneId;
	}

	public String getSceneName() {
		return sceneName;
	}

	public Status getStatus() {
		return Status.getStatus(status);
	}

	public int getTransitionTime() {
		return transitionTime;
	}

}
