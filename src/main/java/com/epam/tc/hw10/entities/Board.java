package com.epam.tc.hw10.entities;

import com.epam.tc.hw10.entities.subentities.LabelNames;
import com.epam.tc.hw10.entities.subentities.Prefs;
import lombok.Data;

@Data
public class Board {
    private String id;
    private String name;
    private String desc;
    private String descData;
    private Boolean closed;
    private String idOrganization;
    private String idEnterprise;
    private Boolean pinned;
    private String url;
    private String shortUrl;
    private Prefs prefs;
    private LabelNames labelNames;
    private transient Object limits;
}
