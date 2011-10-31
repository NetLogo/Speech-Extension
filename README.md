# NetLogo speech extension

This package contains a NetLogo speech-synthesis extension for Mac OS X.

Mac OS X is required.  The extension does not work on other operating systems such as Windows or Linux.

## Using

To install the extension, unzip speech.zip into the extensions directory of your NetLogo distribution.

To use the extension in a model, write 

    extensions [speech]

at the top of the Code tab.

This extension provides two primitives: 

 * voices - reports a list of available voices
 * speak _voice_ _content_ - speaks

For examples that use this extension, see the NetLogo models included with this release.

For more information about NetLogo extensions, see the NetLogo User Manual.

## Building

Use the NETLOGO environment variable to tell the Makefile which NetLogo.jar to compile against.  For example:

    NETLOGO=/Applications/NetLogo\\\ 5.0 make

If compilation succeeds, `speech.jar` will be created.

## Terms of Use

The extension uses "A Humble Narrator", an asynchronous text-to-speech class library by Gregory Guerin. The library is distributed under the "Artistic License" available at http://www.amug.org/~glguerin/sw/artistic-license.html. A standard version of the library, including source code, is available at http://www.amug.org/~glguerin/sw/.

[![CC0](http://i.creativecommons.org/p/zero/1.0/88x31.png)](http://creativecommons.org/publicdomain/zero/1.0/)

The NetLogo speech extension is in the public domain.  To the extent possible under law, Uri Wilensky has waived all copyright and related or neighboring rights.
