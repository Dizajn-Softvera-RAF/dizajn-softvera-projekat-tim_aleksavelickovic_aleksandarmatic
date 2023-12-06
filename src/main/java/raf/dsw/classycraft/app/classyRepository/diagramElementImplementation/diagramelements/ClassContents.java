package raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.diagramelements;

import raf.dsw.classycraft.app.classyRepository.diagramElementImplementation.AccessModifier;

public abstract class ClassContents {
    private String name;
    private AccessModifier accessModifier;

    private String returnType;

    public ClassContents(String name, AccessModifier accessModifier) {
        this.name = name;
        this.accessModifier = accessModifier;
    }

    public ClassContents() {

    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}
