package pages.projects;

import java.util.EnumMap;

public class ProjectsEnumMaps {

    protected static final EnumMap<ProjectsNames,Integer> PROJECTS_LOCATORS_MAP = new EnumMap<>(ProjectsNames.class);
    protected static final EnumMap<ProjectsNames, String> PROJECTS_EXPAND_BTN_MAP = new EnumMap<>(ProjectsNames.class);
    public enum ProjectsNames{
        WONDER_MOSTAKBAL, THREE_POINTS, THE_MEDIAN, THE_BUSINESS_LOUNGE,
        THE_TRINE, LA_MIRADA
    }

    static {
        PROJECTS_LOCATORS_MAP.put(ProjectsNames.WONDER_MOSTAKBAL, 185);
        PROJECTS_LOCATORS_MAP.put(ProjectsNames.THREE_POINTS, 543);
        PROJECTS_LOCATORS_MAP.put(ProjectsNames.THE_MEDIAN, 563);
        PROJECTS_LOCATORS_MAP.put(ProjectsNames.THE_BUSINESS_LOUNGE, 562);
        PROJECTS_LOCATORS_MAP.put(ProjectsNames.THE_TRINE, 564);
        PROJECTS_LOCATORS_MAP.put(ProjectsNames.LA_MIRADA, 566);

        PROJECTS_EXPAND_BTN_MAP.put(ProjectsNames.WONDER_MOSTAKBAL, "the-wonder-marq-mostakbal-city");
        PROJECTS_EXPAND_BTN_MAP.put(ProjectsNames.THREE_POINTS, "3-points-new-capital");
        PROJECTS_EXPAND_BTN_MAP.put(ProjectsNames.THE_MEDIAN, "the-median-residences-new-cairo");
        PROJECTS_EXPAND_BTN_MAP.put(ProjectsNames.THE_BUSINESS_LOUNGE, "the-business-lounge-new-cairo");
        PROJECTS_EXPAND_BTN_MAP.put(ProjectsNames.THE_TRINE, "the-trine-sheikh-zayed");
        PROJECTS_EXPAND_BTN_MAP.put(ProjectsNames.LA_MIRADA, "la-mirada-plaza-new-cairo");    }
}
