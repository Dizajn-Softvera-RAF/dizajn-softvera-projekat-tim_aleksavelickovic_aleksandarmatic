package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;

public abstract class ClassContents {
    private String name;
    private String AccessModifier;

    public ClassContents(String name, String accessModifier) {
        this.name = name;
        AccessModifier = accessModifier;
    }
}
