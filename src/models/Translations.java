package models;

public class Translations {
    int id;
    String textTitle;
    String textContent;
    String textPostDate;
    String textLanguage;
    String textAdminPanel;
    String textAdd;
    String textCancel;
    String textModalTitle;
    String textDetails;
    String textPostedAt;
    String name;
    String textDelete;
    String textForDelete;
    String textSave;

    public Translations(Integer id, String textTitle, String textContent, String textPostDate, String textLanguage, String textAdminPanel, String textAdd, String textCancel, String textModalTitle, String textDetails, String textPostedAt, String name, String textDelete, String textForDelete, String textSave) {
        this.id = id;
        this.textTitle = textTitle;
        this.textContent = textContent;
        this.textPostDate = textPostDate;
        this.textLanguage = textLanguage;
        this.textAdminPanel = textAdminPanel;
        this.textAdd = textAdd;
        this.textCancel = textCancel;
        this.textModalTitle = textModalTitle;
        this.textDetails = textDetails;
        this.textPostedAt = textPostedAt;
        this.name = name;
        this.textDelete = textDelete;
        this.textForDelete = textForDelete;
        this.textSave = textSave;
    }

    public Translations() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public String getTextContent() {
        return textContent;
    }

    public String getTextPostDate() {
        return textPostDate;
    }

    public String getTextLanguage() {
        return textLanguage;
    }

    public String getTextAdminPanel() {
        return textAdminPanel;
    }

    public String getTextAdd() {
        return textAdd;
    }

    public String getTextCancel() {
        return textCancel;
    }

    public String getTextModalTitle() {
        return textModalTitle;
    }

    public String getTextDetails() {
        return textDetails;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setTextPostDate(String textPostDate) {
        this.textPostDate = textPostDate;
    }

    public void setTextLanguage(String textLanguage) {
        this.textLanguage = textLanguage;
    }

    public void setTextAdminPanel(String textAdminPanel) {
        this.textAdminPanel = textAdminPanel;
    }

    public void setTextAdd(String textAdd) {
        this.textAdd = textAdd;
    }

    public void setTextCancel(String textCancel) {
        this.textCancel = textCancel;
    }

    public void setTextModalTitle(String textModalTitle) {
        this.textModalTitle = textModalTitle;
    }

    public void setTextDetails(String textTextDetails) {
        this.textDetails = textTextDetails;
    }

    public String getTextPostedAt() {
        return textPostedAt;
    }

    public void setTextPostedAt(String textPostedAt) {
        this.textPostedAt = textPostedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextDelete() {
        return textDelete;
    }

    public void setTextDelete(String textDelete) {
        this.textDelete = textDelete;
    }

    public String getTextForDelete() {
        return textForDelete;
    }

    public void setTextForDelete(String textForDelete) {
        this.textForDelete = textForDelete;
    }

    public String getTextSave() {
        return textSave;
    }

    public void setTextSave(String textSave) {
        this.textSave = textSave;
    }
}

