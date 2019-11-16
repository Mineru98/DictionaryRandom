# DictionaryRandom
This function returns a random value from a predefined array.

## Define
- 사전에 있는 데이터에 대한 난수
- 변수(빈도값:Emersion)
  - 자료 시각화를 위한 Charting

## Kotlin Usage
```
kotlinc ~/kotlin/main.kt -include-runtime -d ~/kotlin/main.jar && java -jar /workspace/DRKotlin/kotlin/main.jar

java -jar kotlin/main.jar
```

## DB
`
CREATE DATABASE dictionary DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
`

`
mysql -uroot -p dictionary -e "SELECT result FROM DataInfo" | sed 's/\t/","/g;s/^/"/;s/$/"/;' > data.csv
`