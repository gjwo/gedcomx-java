package org.gedcomx.examples;

import org.gedcomx.Gedcomx;
import org.gedcomx.common.Qualifier;
import org.gedcomx.conclusion.Name;
import org.gedcomx.conclusion.NameForm;
import org.gedcomx.conclusion.NamePart;
import org.gedcomx.conclusion.Person;
import org.gedcomx.rt.SerializationUtil;
import org.gedcomx.types.NamePartQualifierType;
import org.gedcomx.types.NamePartType;
import org.testng.annotations.Test;

/**
 * @author Ryan Heaton
 */
@Test
public class NamesExampleTest {

  public void testBasicWesternName() throws Exception {
    NameForm nameForm = new NameForm("John Fitzgerald Kennedy")
      .lang("en")
      .part(NamePartType.Given, "John")
      .part(NamePartType.Given, "Fitzgerald")
      .part(NamePartType.Surname, "Kennedy");
    Name name = new Name().nameForm(nameForm);

    Gedcomx gx = new Gedcomx().person(new Person().name(name));
    SerializationUtil.processThroughXml(gx);
    SerializationUtil.processThroughJson(gx);
  }

  public void testMultipleJapaneseForms() throws Exception {
    NameForm kanji = new NameForm("山田太郎")
      .lang("ja-Hani")
      .part(NamePartType.Surname, "山田")
      .part(NamePartType.Given, "太郎");
    NameForm katakana = new NameForm("ヤマダタロー")
      .lang("ja-Kana")
      .part(NamePartType.Surname, "ヤマダ")
      .part(NamePartType.Given, "タロー");
    NameForm romanized = new NameForm("Yamada Tarō")
      .lang("ja-Latn")
      .part(NamePartType.Surname, "Tarō")
      .part(NamePartType.Given, "Yamada");
    Name name = new Name().nameForm(kanji).nameForm(katakana).nameForm(romanized);

    Gedcomx gx = new Gedcomx().person(new Person().name(name));
    SerializationUtil.processThroughXml(gx);
    SerializationUtil.processThroughJson(gx);
  }

  public void testMultipleNamePartsOnePartPerType() throws Exception {
    NameForm nameForm = new NameForm("José Eduardo Santos Tavares Melo Silva")
      .lang("pt-BR")
      .part(NamePartType.Given, "José Eduardo")
      .part(NamePartType.Surname, "Santos Tavares Melo Silva");
    Name name = new Name().nameForm(nameForm);

    Gedcomx gx = new Gedcomx().person(new Person().name(name));
    SerializationUtil.processThroughXml(gx);
    SerializationUtil.processThroughJson(gx);
  }

  public void testMultipleNamePartsMultiplePartsPerType() throws Exception {
    NameForm nameForm = new NameForm("José Eduardo Santos Tavares Melo Silva")
      .lang("pt-BR")
      .part(NamePartType.Given, "José")
      .part(NamePartType.Given, "Eduardo")
      .part(NamePartType.Surname, "Santos")
      .part(NamePartType.Surname, "Tavares")
      .part(NamePartType.Surname, "Melo")
      .part(NamePartType.Surname, "Silva");
    Name name = new Name().nameForm(nameForm);

    Gedcomx gx = new Gedcomx().person(new Person().name(name));
    SerializationUtil.processThroughXml(gx);
    SerializationUtil.processThroughJson(gx);
  }

  public void testPatronymic() throws Exception {
    NameForm nameForm = new NameForm("Björk Guðmundsdóttir")
      .lang("is")
      .part(NamePartType.Given, "Björk")
      .part(new NamePart().value("Guðmundsdóttir").qualifier(new Qualifier(NamePartQualifierType.Patronymic)));
    Name name = new Name().nameForm(nameForm);

    Gedcomx gx = new Gedcomx().person(new Person().name(name));
    SerializationUtil.processThroughXml(gx);
    SerializationUtil.processThroughJson(gx);
  }

}
