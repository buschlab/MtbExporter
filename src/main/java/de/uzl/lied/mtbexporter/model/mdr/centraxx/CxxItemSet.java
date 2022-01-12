package de.uzl.lied.mtbexporter.model.mdr.centraxx;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"caption",
"items",
"folderId",
"version",
"validFrom",
"validUntil",
"approvalStatus",
"modificationTime",
"systemUrl",
})
public class CxxItemSet {

private String id;
private CxxCaption caption;
private List<CxxItem> items = null;
private String folderId;
private Integer version;
private Object validFrom;
private Object validUntil;
private String approvalStatus;
private Long modificationTime;
private String systemUrl;
private List<CxxLinks> links;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public CxxCaption getCaption() {
return caption;
}

public void setCaption(CxxCaption caption) {
this.caption = caption;
}

public List<CxxItem> getItems() {
return items;
}

public void setItems(List<CxxItem> items) {
this.items = items;
}

public String getFolderId() {
return folderId;
}

public void setFolderId(String folderId) {
this.folderId = folderId;
}

public Integer getVersion() {
return version;
}

public void setVersion(Integer version) {
this.version = version;
}

public Object getValidFrom() {
return validFrom;
}

public void setValidFrom(Object validFrom) {
this.validFrom = validFrom;
}

public Object getValidUntil() {
return validUntil;
}

public void setValidUntil(Object validUntil) {
this.validUntil = validUntil;
}

public String getApprovalStatus() {
return approvalStatus;
}

public void setApprovalStatus(String approvalStatus) {
this.approvalStatus = approvalStatus;
}

public Long getModificationTime() {
return modificationTime;
}

public void setModificationTime(Long modificationTime) {
this.modificationTime = modificationTime;
}

public String getSystemUrl() {
return systemUrl;
}

public void setSystemUrl(String systemUrl) {
this.systemUrl = systemUrl;
}

public List<CxxLinks> getLinks() {
return links;
}

public void setLinks(List<CxxLinks> links) {
this.links = links;
}

}