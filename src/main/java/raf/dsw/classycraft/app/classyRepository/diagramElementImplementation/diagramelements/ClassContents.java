package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;

public abstract class ClassContents {
    private String name;
    private String AccessModifier;

    public ClassContents(String name, String accessModifier) {
        this.name = name;
        AccessModifier = accessModifier;
    }

    public String getName() {
        return name;
    }

    public String getAccessModifier() {
        return AccessModifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccessModifier(String accessModifier) {
        AccessModifier = accessModifier;
    }
}
