package CSC110.monopoly.board;

public class RenderAssistant {
	public static String EmptyLine(){
		return "*                     *";
	}
	public static String BorderLine(){
		return "***********************";
	}
	public static String BlankLine(){
		return "                       ";
	}
	

	public static String[] SpliceTile(String[] splicePerLine){
		String[] ret = BaseTile();
		for(int i = 1; i < ret.length-1; i++){
			if(i > splicePerLine.length) break;
			ret[i] = Splice(ret[i],splicePerLine[i-1]);
		}
		return ret;
	}
	private static String[] BaseTile(){return new String[]{
			RenderAssistant.BorderLine(),	
			RenderAssistant.EmptyLine(),	
			RenderAssistant.EmptyLine(),	
			RenderAssistant.EmptyLine(),	
			RenderAssistant.EmptyLine(),	
			RenderAssistant.EmptyLine(),	
			RenderAssistant.EmptyLine(),	
			RenderAssistant.BorderLine(),	
		};
	}
	public static String[] EmptyTile(){return new String[]{
			RenderAssistant.BlankLine(),	
			RenderAssistant.BlankLine(),	
			RenderAssistant.BlankLine(),	
			RenderAssistant.BlankLine(),	
			RenderAssistant.BlankLine(),	
			RenderAssistant.BlankLine(),	
			RenderAssistant.BlankLine(),	
			RenderAssistant.BlankLine(),	
		};
	}
	
	public static String Splice(String initial, String spliceIn){
		return Splice(initial, spliceIn, 1, initial.length()-2, true, true);
	}
	public static String Splice(String initial, String spliceIn, int startingAt, int endingWhere, boolean preserveInitialLength, boolean center){
		int replaceableLength = initial.length() - startingAt - (initial.length()-endingWhere) -1;
		int padding = 0, spliceStart = startingAt;
		if(center){
			int spliceInCenter = (spliceIn.length()-1)/2;
			int lineCenter = (replaceableLength/2) + startingAt;
			
			spliceStart = Math.abs(lineCenter - spliceInCenter);
		}
		if(preserveInitialLength){
			if(replaceableLength <= spliceIn.length()){
				spliceIn = spliceIn.substring(0, replaceableLength);
			}else{
				padding = replaceableLength-spliceIn.length();
			}
		}
		
		int charCount = (initial.length() - replaceableLength) + spliceIn.length() + padding;
		String ret = "";
		for(int i = 0; i < charCount; i++){
			if(i < spliceStart){
				if(i < startingAt){
					ret += initial.charAt(i);
				}else{
					ret += " ";
				}
			}else if(i <= endingWhere){
				if(i - spliceStart < spliceIn.length()){
					ret += spliceIn.charAt(i - spliceStart);
				}else{
					ret += " ";
				}
			}else{
				if(i < initial.length()){
					ret += initial.charAt(i);
				}else{
					ret += "E";
				}
			}
		}
		return ret;
	}
}
