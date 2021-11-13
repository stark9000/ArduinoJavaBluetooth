#include <SoftwareSerial.h>
SoftwareSerial btm(9, 10);

int LED_1 = 4;
int LED_2 = 5;
int LED_3 = 6;
int LED_4 = 7;
int LED_5 = 8;

int BTN_1 = A0;
int BTN_2 = A1;
int BTN_3 = A2;
int BTN_4 = A3;
int BTN_5 = A4;

char c;

unsigned long PREVIOUSMILLIS = 0;
const long INTERVAL = 100;

void setup() {
  Serial.begin(9600);
  btm.begin(9600);
  pinMode(LED_1, OUTPUT);
  pinMode(LED_2, OUTPUT);
  pinMode(LED_3, OUTPUT);
  pinMode(LED_4, OUTPUT);
  pinMode(LED_5, OUTPUT);

  pinMode(BTN_1, INPUT);
  pinMode(BTN_2, INPUT);
  pinMode(BTN_3, INPUT);
  pinMode(BTN_4, INPUT);
  pinMode(BTN_5, INPUT);

  digitalWrite(LED_1, HIGH);
  digitalWrite(LED_2, HIGH);
  digitalWrite(LED_3, HIGH);
  digitalWrite(LED_4, HIGH);
  digitalWrite(LED_5, HIGH);
  delay(1000);
  digitalWrite(LED_1, LOW);
  digitalWrite(LED_2, LOW);
  digitalWrite(LED_3, LOW);
  digitalWrite(LED_4, LOW);
  digitalWrite(LED_5, LOW);
}

void loop() {
  if (btm.available() > 0) {
    c = btm.read();
    if (c == 'a') {
      digitalWrite(LED_1, HIGH);
    } else if (c == 'A') {
      digitalWrite(LED_1, LOW);
    } else if (c == 'b') {
      digitalWrite(LED_2, HIGH);
    } else if (c == 'B') {
      digitalWrite(LED_2, LOW);
    } else if (c == 'c') {
      digitalWrite(LED_3, HIGH);
    } else if (c == 'C') {
      digitalWrite(LED_3, LOW);
    } else if (c == 'd') {
      digitalWrite(LED_4, HIGH);
    } else if (c == 'D') {
      digitalWrite(LED_4, LOW);
    } else if (c == 'e') {
      digitalWrite(LED_5, HIGH);
    } else if (c == 'E') {
      digitalWrite(LED_5, LOW);
    }
  }
  unsigned long CURRENTMILLIS = millis();
  if (CURRENTMILLIS - PREVIOUSMILLIS >= INTERVAL) {
    PREVIOUSMILLIS = CURRENTMILLIS;
    if (!digitalRead(BTN_1)) {
      btm.print("F");
    } else {
      btm.print("f");
    }


    if (!digitalRead(BTN_2)) {
      btm.print("G");
    } else {
      btm.print("g");
    }

    if (!digitalRead(BTN_3)) {
      btm.print("H");
    } else {
      btm.print("h");
    }

    if (!digitalRead(BTN_4)) {
      btm.print("I");
    } else {
      btm.print("i");
    }

    if (!digitalRead(BTN_5)) {
      btm.println("J");
    } else {
      btm.print("j");
    }
  }
}
