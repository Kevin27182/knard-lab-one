
// Title: Denomination.java
// Author: Kevin Nard
// Denomination record contains four fields:
//      `name` - the name of the Denomination
//      `amt` - the amount of the Denomination
//      `form` - whether the Denomination is a note or a coin
//      `img` - the path to an image of the Denomination

public record Denomination(String name
                          ,double amt
                          ,Form form
                          ,String img) { }
