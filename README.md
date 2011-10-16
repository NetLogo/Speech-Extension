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

All other contents (C) 2004-2011 Uri Wilensky.

The contents of this package, except as noted above, may be freely copied, distributed, altered, or otherwise used by anyone for any legal purpose.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
