package it.fivenet.playground.library.domain;

public enum OrderStatus {

    NOLEGGIATO{
        @Override
        public String toString() {
            return "Noleggiato";
        }
    },
    RESTITUITO{
        @Override
        public String toString() {
            return "Restituito";
        }
    },
    CANCELLATO{
        @Override
        public String toString() {
            return "Cancellato";
        }
    },
}


