# DictionaryRandom
This function returns a random value from a predefined array.

## Define
- 사전에 있는 데이터에 대한 난수
- 변수(빈도값:Emersion)

## Kotlin Usage
```
kotlinc ~/kotlin/main.kt -include-runtime -d ~/kotlin/main.jar && java -jar /workspace/DRKotlin/kotlin/main.jar

kotlinc /workspace/DRKotlin/kotlin/main.kt -include-runtime -d /workspace/DRKotlin/kotlin/main.jar && java -jar /workspace/DRKotlin/kotlin/main.jar

java -jar kotlin/main.jar
```

## Java Usage
```
// build
mkdir -p /workspace/DictionaryRandom/java/bin/ && mkdir -p /workspace/DictionaryRandom/java/jar/ && javac -encoding UTF-8 -cp "$(find /workspace/DictionaryRandom/java/jar/ -name *.jar -printf %p:)" -d /workspace/DictionaryRandom/java/bin/ -g $(find /workspace/DictionaryRandom/java/src/ -name *.java)
// run
mkdir -p /workspace/DictionaryRandom/java/bin/ && mkdir -p /workspace/DictionaryRandom/java/jar/ && javac -encoding UTF-8 -cp "$(find /workspace/DictionaryRandom/java/jar/ -name *.jar -printf %p:)" -d /workspace/DictionaryRandom/java/bin/ -g $(find /workspace/DictionaryRandom/java/src/ -name *.java) && java -Dfile.encoding=UTF-8 -cp "$(find /workspace/DictionaryRandom/java/jar/ -name *.jar -printf %p:)/workspace/DictionaryRandom/java/bin/" DictionaryRandom/Main
```

## DB
`
CREATE DATABASE dictionary DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
`

`
mysql -uroot -p dictionary -e "SELECT result FROM DataInfo" | sed 's/\t/","/g;s/^/"/;s/$/"/;' > data.csv
`