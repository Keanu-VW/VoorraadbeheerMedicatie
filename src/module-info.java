module VoorraadBeheer{
    requires javafx.controls;
    requires java.desktop;

    opens VoorraadBeheer.Model to javafx.base;

    exports VoorraadBeheer;
}