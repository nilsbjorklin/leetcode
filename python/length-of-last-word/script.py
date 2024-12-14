import timeit
from unittest import TestCase


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        result = 0
        idx = len(s) - 1
        while True:
            if s[idx] == ' ':
                if result:
                    return result
            else:
                result += 1
            idx -= 1

    def lengthOfLastWord2(self, s: str) -> int:
        s = s.strip()
        return len(s) - s.rfind(' ') - 1

    def lengthOfLastWord3(self, s: str) -> int:
        return len(s.strip()[::-1].split(' ')[0])


class Test(TestCase):
    data = '''
    Lorem ipsum odor amet, consectetuer adipiscing elit. Tellus integer vestibulum 
    curabitur a volutpat sociosqu. Elementum porttitor natoque dignissim augue habitasse porta per ante. 
    Suscipit auctor luctus integer facilisi nulla. Lectus magnis mollis ad tristique leo vulputate, erat aptent. 
    Ultricies fames ultricies mattis eros fusce, elementum cras mus? Curabitur magnis mauris tempor non quis non habitant. 
    Varius ligula magnis himenaeos, et pretium quisque. Sem nunc cubilia neque consequat sollicitudin tempus. Elit cl
    ss nisi curae; ligula enim augue est purus maximus. Per tempus dapibus sollicitudin magna aliquet; a urna. Ex euism
    od vestibulum lobortis justo id ultrices aliquam. Tincidunt eget cras; ante elementum primis scelerisque lectus. Torquent nisi
    sed eleifend morbi; dui vestibulum aliquam senectus. Vehicula consectetur urna cras habitant fusce convallis praesent. Augue consequat
    est proin a nulla ultrices sociosqu. Potenti consequat eleifend vivamus taciti sollicitudin, curabitur iaculis nam turpis. Platea sapie
    n justo orci bibendum semper justo fringilla pulvinar. Aliquam cursus laoreet lacus fermentum ex vulputate. Sem convallis sagittis netus
    fermentum inceptos. Cursus pretium ultricies magna taciti consectetur vestibulum dolor. Hendrerit nascetur aliquam amet purus conubia mae
    cenas dui. Dapibus augue cursus pellentesque donec sodales lacinia quisque. Metus aliquet phasellus risus 
    amet tortor nulla dolor. Fames phasellus gravida habitant egestas ullamcorper dignissim, mus hac 
    aenean. Venenatis vel est auctor aliquet adipiscing potenti eget pellentesque. Viverra
    posuere posuere nascetur non nam, ultrices senectus. Amet maximus aliquam egestas dapibus interdum consequa
    t orci habitant. Habitant leo orci ante duis faucibus auctor sapien ut. Ut nostra vehicula egestas fusce a litora eleifend. Est d
    ignissim vitae vestibulum; cursus ultricies elementum dis fusce. Non q
    uis ligula primis tortor gravida dictum mauris himenaeos. Placerat fringilla tempor facilisis aptent senectus luctus posuere. Lac
    us ut blandit convallis accumsan in faucibus sed taciti. Aliquam sapien dui hendrerit; taciti sociosqu nisi aptent. Laoreet gravida proin mas
    sa egestas, sociosqu pulvinar. Facilisi curae aliquet; fusce cubilia ante quisque natoque nascetur. Tristique incep
    tos taciti eleifend parturient dignissim tempor. Metus vehicula elementum ullamcorper sed amet sem; at
    vel elementum. Eu scelerisque taciti fringilla sodales ad posuere neque congue sed. Ipsum gr
    avida auctor ante phasellus consectetur mauris facilisi. At tortor ligula, sagittis libero tellus purus. Dictum egest
    as metus parturient enim velit. Amet convallis adipiscing sociosqu dis fames nullam dolor. Nibh diam nascetur viverra vehicula nec aliq
    uet. Nisi erat at ad mollis massa faucibus rutrum massa. Parturient facilisis ex urna proin rhoncus. Ullamcorp
    er nisi elit aliquam integer facilisis fusce. Pulvinar praesent adipiscing arcu viverra primis litora bibendum posuere sit.
    Senectus vitae est aliquam, eros elementum dolor erat feugiat. Dapibus torquent pretium lacinia venenatis laoreet
    id. Euismod id odio semper lacus rhoncus imperdiet. Mus orci convallis convallis; habitasse porta aliquam. Quam aliquam 
    nisl nullam sodales donec. Varius nostra orci facilisi class tortor. Fermentum dictum eget ex ligula nascetu
    r a. Penatibus diam primis volutpat vulputate quam diam elementum quis. Vivamus consectetur cra
    s sem lectus finibus libero. Venenatis cras dolor fusce est facilisis taciti. Dui massa natoque risus ante 
    dui viverra lectus erat. Turpis semper sem platea interdum mattis cras nec fermentum. Nisl ex blandit ridiculus lec
    tus quisque aliquet praesent cubilia. Pharetra magna finibus suscipit vulputate lobortis, bibendum mi ipsum. Magnis turpis 
    proin orci diam consectetur non mollis. Porttitor vestibulum est venenatis conubia conubia est a eget. Montes imperdiet leo dictum
    st ultrices sit quam? Bibendum congue et ac dapibus platea semper malesuada sollicitudin. Lobortis praesent risus mauris libero velit m
    assa volutpat imperdiet. Massa odio tristique magnis augue molestie purus. Non dictum molestie adipiscing primis aliquet dolor sed. Magni
    s ligula sem arcu venenatis cursus blandit integer conubia scelerisque. Nisl torquent libero pretium vivamus maecenas, i
    nceptos phasellus. Mattis eget in morbi pulvinar blandit penatibus. Congue tempus mollis iaculis facilisis na
    scetur purus. Massa conubia eu sagittis integer sollicitudin dignissim morbi platea. In urna arcu lorem taciti purus eu 
    dui sagittis erat. Litora nostra blandit consectetur proin aliquam? Tristique consequat tempor gravida natoque ullamcorper curab
    itur sit pretium. Ultricies luctus fermentum scelerisque at lacinia fames. Auctor class massa mus lacus nullam hendrerit posuere! Nunc nu
    lla euismod congue; pellentesque taciti quisque pulvinar. Lobortis fames primis porttitor tempus; sem lacinia. Aprimis volutpat cubilia rutrum co
    nvallis. Convallis ipsum porta interdum diam aenean pellentesque rhoncus quam ligula. Enim fermentum non conubia cras ultrices cras faci
    lisi nascetur. Scelerisque nibh platea leo, mattis erat lobortis aliquet. Fermentum augue inceptos nec ut nunc facilisi non tris
    tique. Iaculis ligula conubia; tellus lacinia id ornare. Integer amet malesuada praesent viverra, vehicula donec elementum o
    rci. Torquent vel nascetur gravida rhoncus tortor lacus. Iaculis commodo malesuada id vivamus mattis volutpat. Tincidunt odio
    vel vel etiam mollis fermentum himenaeos. Accumsan orci erat netus dolor urna phasellus aenean quisque. Feugiat facilisi netus
    eu magnis habitant mattis sem. At nisl morbi pretium leo himenaeos litora aliquam; senectus sodales. Proin cursus ridiculus erat magna 
    sem torquent sollicitudin ipsum facilisi. Venenatis praesent penatibus at dictum efficitur habitasse praesent.
    '''
    def test_1(self):
        self.assertEqual(5, Solution().lengthOfLastWord("Hello World"))

    def test_2(self):
        self.assertEqual(4, Solution().lengthOfLastWord2("   fly me   to   the moon  "))

    def test_3(self):
        self.assertEqual(6, Solution().lengthOfLastWord("luffy is still joyboy"))

    def test_execution_time(self):
        print(timeit.timeit(lambda: (Solution().lengthOfLastWord(line) for line in self.data.split()), number=100000))
        print(timeit.timeit(lambda: (Solution().lengthOfLastWord2(line) for line in self.data.split()), number=100000))
        print(timeit.timeit(lambda: (Solution().lengthOfLastWord3(line) for line in self.data.split()), number=100000))
