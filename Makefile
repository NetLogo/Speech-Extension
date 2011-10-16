ifeq ($(origin JAVA_HOME), undefined)
  JAVA_HOME=/usr
endif

ifeq ($(origin NETLOGO), undefined)
  NETLOGO=../..
endif

SRCS=$(wildcard src/*.java)

speech.jar: $(SRCS) Narrator-20060606.jar manifest.txt
	mkdir -p classes
	$(JAVA_HOME)/bin/javac -g -encoding us-ascii -source 1.5 -target 1.5 -classpath $(NETLOGO)/NetLogoLite.jar:Narrator-20060606.jar -d classes $(SRCS)
	jar cmf manifest.txt speech.jar -C classes .

Narrator-20060606.jar:
	curl -s 'http://ccl.northwestern.edu/devel/Narrator-20060606.jar' -o Narrator-20060606.jar

speech.zip: speech.jar
	rm -rf speech
	mkdir speech
	cp -rp speech.jar Narrator-20060606.jar README.md Makefile src manifest.txt speech
	zip -rv speech.zip speech
	rm -rf speech
