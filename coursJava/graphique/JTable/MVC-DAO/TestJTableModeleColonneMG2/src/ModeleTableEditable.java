// ==========================================================================
// Classe ModeleTableEditable                                      TestJTable
// ==========================================================================

import utilitairesMG.graphique.table.*;

public class ModeleTableEditable extends ModeleTable
{

// --------------------------------------------------------------------------
// getRowCount : nombre de lignes de la JTable
// --------------------------------------------------------------------------
   public int getRowCount()
   {
      return super.getRowCount() + 1;
   }


   public boolean isCellEditable(int l, int c)
   {
      return true;
   }
}

 