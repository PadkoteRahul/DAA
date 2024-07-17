/*
Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert given expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[yxz]a[b,c]

Sample Output-3:
----------------
[xab, xac, yab, yac, zab, zac]


=== testcases ===
case =1
input =[a,b,c,d]e[x,y,z]
output =[aex, aey, aez, bex, bey, bez, cex, cey, cez, dex, dey, dez]

case =2
input =[ab,cd]x[y,z]
output =[abxy, abxz, cdxy, cdxz]

case =3
input =abcd[x,y,z]f
output =[abcdxf, abcdyf, abcdzf]

case =4
input =[abc][d,e]f[g,h,i]j
output =[abcdfgj, abcdfhj, abcdfij, abcefgj, abcefhj, abcefij]

case =5
input =abcdef
output =[abcdef]

case =6
input =abc[e,f]j[k,l][g,h]
output =[abcejkg, abcejkh, abcejlg, abcejlh, abcfjkg, abcfjkh, abcfjlg, abcfjlh]

case =7
input =[a,bc,abc,cd,bcd][a,c,b,d,f,e][i,p,m,n,q]
output =[aai, aam, aan, aap, aaq, abcai, abcam, abcan, abcap, abcaq, abcbi, abcbm, abcbn, abcbp, abcbq, abcci, abccm, abccn, abccp, abccq, abcdi, abcdm, abcdn, abcdp, abcdq, abcei, abcem, abcen, abcep, abceq, abcfi, abcfm, abcfn, abcfp, abcfq, abi, abm, abn, abp, abq, aci, acm, acn, acp, acq, adi, adm, adn, adp, adq, aei, aem, aen, aep, aeq, afi, afm, afn, afp, afq, bcai, bcam, bcan, bcap, bcaq, bcbi, bcbm, bcbn, bcbp, bcbq, bcci, bccm, bccn, bccp, bccq, bcdai, bcdam, bcdan, bcdap, bcdaq, bcdbi, bcdbm, bcdbn, bcdbp, bcdbq, bcdci, bcdcm, bcdcn, bcdcp, bcdcq, bcddi, bcddm, bcddn, bcddp, bcddq, bcdei, bcdem, bcden, bcdep, bcdeq, bcdfi, bcdfm, bcdfn, bcdfp, bcdfq, bcdi, bcdm, bcdn, bcdp, bcdq, bcei, bcem, bcen, bcep, bceq, bcfi, bcfm, bcfn, bcfp, bcfq, cdai, cdam, cdan, cdap, cdaq, cdbi, cdbm, cdbn, cdbp, cdbq, cdci, cdcm, cdcn, cdcp, cdcq, cddi, cddm, cddn, cddp, cddq, cdei, cdem, cden, cdep, cdeq, cdfi, cdfm, cdfn, cdfp, cdfq]

case =8
input =[a,b,c,d,e]km[m,l,k,j,i,h,g,f]t[s,t,u,r,q,p,o,n]
output =[akmftn, akmfto, akmftp, akmftq, akmftr, akmfts, akmftt, akmftu, akmgtn, akmgto, akmgtp, akmgtq, akmgtr, akmgts, akmgtt, akmgtu, akmhtn, akmhto, akmhtp, akmhtq, akmhtr, akmhts, akmhtt, akmhtu, akmitn, akmito, akmitp, akmitq, akmitr, akmits, akmitt, akmitu, akmjtn, akmjto, akmjtp, akmjtq, akmjtr, akmjts, akmjtt, akmjtu, akmktn, akmkto, akmktp, akmktq, akmktr, akmkts, akmktt, akmktu, akmltn, akmlto, akmltp, akmltq, akmltr, akmlts, akmltt, akmltu, akmmtn, akmmto, akmmtp, akmmtq, akmmtr, akmmts, akmmtt, akmmtu, bkmftn, bkmfto, bkmftp, bkmftq, bkmftr, bkmfts, bkmftt, bkmftu, bkmgtn, bkmgto, bkmgtp, bkmgtq, bkmgtr, bkmgts, bkmgtt, bkmgtu, bkmhtn, bkmhto, bkmhtp, bkmhtq, bkmhtr, bkmhts, bkmhtt, bkmhtu, bkmitn, bkmito, bkmitp, bkmitq, bkmitr, bkmits, bkmitt, bkmitu, bkmjtn, bkmjto, bkmjtp, bkmjtq, bkmjtr, bkmjts, bkmjtt, bkmjtu, bkmktn, bkmkto, bkmktp, bkmktq, bkmktr, bkmkts, bkmktt, bkmktu, bkmltn, bkmlto, bkmltp, bkmltq, bkmltr, bkmlts, bkmltt, bkmltu, bkmmtn, bkmmto, bkmmtp, bkmmtq, bkmmtr, bkmmts, bkmmtt, bkmmtu, ckmftn, ckmfto, ckmftp, ckmftq, ckmftr, ckmfts, ckmftt, ckmftu, ckmgtn, ckmgto, ckmgtp, ckmgtq, ckmgtr, ckmgts, ckmgtt, ckmgtu, ckmhtn, ckmhto, ckmhtp, ckmhtq, ckmhtr, ckmhts, ckmhtt, ckmhtu, ckmitn, ckmito, ckmitp, ckmitq, ckmitr, ckmits, ckmitt, ckmitu, ckmjtn, ckmjto, ckmjtp, ckmjtq, ckmjtr, ckmjts, ckmjtt, ckmjtu, ckmktn, ckmkto, ckmktp, ckmktq, ckmktr, ckmkts, ckmktt, ckmktu, ckmltn, ckmlto, ckmltp, ckmltq, ckmltr, ckmlts, ckmltt, ckmltu, ckmmtn, ckmmto, ckmmtp, ckmmtq, ckmmtr, ckmmts, ckmmtt, ckmmtu, dkmftn, dkmfto, dkmftp, dkmftq, dkmftr, dkmfts, dkmftt, dkmftu, dkmgtn, dkmgto, dkmgtp, dkmgtq, dkmgtr, dkmgts, dkmgtt, dkmgtu, dkmhtn, dkmhto, dkmhtp, dkmhtq, dkmhtr, dkmhts, dkmhtt, dkmhtu, dkmitn, dkmito, dkmitp, dkmitq, dkmitr, dkmits, dkmitt, dkmitu, dkmjtn, dkmjto, dkmjtp, dkmjtq, dkmjtr, dkmjts, dkmjtt, dkmjtu, dkmktn, dkmkto, dkmktp, dkmktq, dkmktr, dkmkts, dkmktt, dkmktu, dkmltn, dkmlto, dkmltp, dkmltq, dkmltr, dkmlts, dkmltt, dkmltu, dkmmtn, dkmmto, dkmmtp, dkmmtq, dkmmtr, dkmmts, dkmmtt, dkmmtu, ekmftn, ekmfto, ekmftp, ekmftq, ekmftr, ekmfts, ekmftt, ekmftu, ekmgtn, ekmgto, ekmgtp, ekmgtq, ekmgtr, ekmgts, ekmgtt, ekmgtu, ekmhtn, ekmhto, ekmhtp, ekmhtq, ekmhtr, ekmhts, ekmhtt, ekmhtu, ekmitn, ekmito, ekmitp, ekmitq, ekmitr, ekmits, ekmitt, ekmitu, ekmjtn, ekmjto, ekmjtp, ekmjtq, ekmjtr, ekmjts, ekmjtt, ekmjtu, ekmktn, ekmkto, ekmktp, ekmktq, ekmktr, ekmkts, ekmktt, ekmktu, ekmltn, ekmlto, ekmltp, ekmltq, ekmltr, ekmlts, ekmltt, ekmltu, ekmmtn, ekmmto, ekmmtp, ekmmtq, ekmmtr, ekmmts, ekmmtt, ekmmtu]

*/

import java.util.*;

public class BraceExpressionChar 
{
	public String[] expand(String S) 
	{
		List<String> res = new ArrayList<>();
		dfs(S, 0, new StringBuilder(), res);   

		String[] out = new String[res.size()];
		for (int i = 0; i < res.size(); i++) 
		{ 
			out[i] = res.get(i); 
		}		
		return out;
	}
  
	private void dfs(String s, int index, StringBuilder sb, List<String> res) 
	{
		System.out.println("index: " + index + " stringBuffer: " + sb.toString());
		if (index == s.length()) 
		{
			if (sb.length() > 0) 
			{ 
				res.add(sb.toString()); 
			}
			return;
		}
      
		char c = s.charAt(index);
		System.out.println("char: " + c + " index: " + index);
		int position = sb.length();
		if (c == '[') 
		{
			List<Character> charList = new ArrayList<>();
			int endIndex = index + 1;
			while (endIndex < s.length() && s.charAt(endIndex) != ']') 
			{ 
				if (Character.isLetter(s.charAt(endIndex))) 
				{
					charList.add(s.charAt(endIndex)); 
				}
				endIndex++; 
			}    
          
			System.out.println("charList: " + charList);
			Collections.sort(charList);
			for (char d : charList) 
			{
				sb.append(d);
				dfs(s, endIndex + 1, sb, res);
				sb.setLength(position);
			}
          
		} 
		else if (Character.isLetter(c)) 
		{
			System.out.println("index: " + index + " s.charAt(index): " + s.charAt(index));
			sb.append(s.charAt(index));
			dfs(s, index + 1, sb, res);    
		}
	}

	public static void main(String args[] ) {
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		System.out.println(Arrays.deepToString(new BraceExpressionChar().expand(str)));
	}	
}
