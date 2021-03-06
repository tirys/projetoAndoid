package br.edu.fatecriopreto.projetoandoid.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.edu.fatecriopreto.projetoandoid.Entity.Comentarios;
import br.edu.fatecriopreto.projetoandoid.R;

/**
 * Created by Jessica on 29/05/2015.
 */
public class LstComentariosAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Comentarios> posts;

    public LstComentariosAdapter(Context context,List<Comentarios> posts){
        this.posts=posts;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return posts.size(); //retorna qtd de itens

    }

    @Override
    public Comentarios getItem(int position){
        return posts.get(position); //retorna o item na posicao indicada
    }



    @Override
    public  long getItemId(int position){
        return position;
    }

    private class ItemSuporte{

        TextView txtComentario;
        ImageView imgUserC;
        TextView txtNomeCom;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //metodo que preenche o layout com os dados do item
        ItemSuporte item;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.lista_comentarios, null); //coloca o layout na visualização

            item = new ItemSuporte();

            item.txtComentario = (TextView) convertView.findViewById(R.id.txtComentario);
            item.imgUserC = (ImageView) convertView.findViewById(R.id.imgUserCom);
            item.txtNomeCom = (TextView) convertView.findViewById(R.id.txtnomeuser);


            convertView.setTag(item);

        }else{
            item=(ItemSuporte) convertView.getTag(); //pega o layout
        }

        Comentarios post = getItem(position); //recupera o objeto veiculo da lista
        // item.txtTituloPost.setText(veiculo.getPlaca()); //adicionando no itemplaca configurado no layout
        // item.txtDescricaoPost.setText(veiculo.getMarca());
       //  item.txtTituloPost.setText(post.getNome());
     //   item.txtDescricaoPost.setText(post.getDescricao());

        item.txtComentario.setText(post.getConteudo());
        String ImgUser = post.getImgPessoa();
        if(ImgUser != null) {
            byte[] bt = Base64.decode(ImgUser, Base64.DEFAULT);
            //String bt = listAux.get(position).getImgByte();
            Bitmap userfoto = BitmapFactory.decodeByteArray(bt, 0, bt.length);
            //imgFoto.setImageBitmap(userfoto);

            //item.txtDescricaoPost.setText("conteudo conteudo conteudo");
            item.imgUserC.setImageBitmap(userfoto);
            item.txtNomeCom.setText(post.getNomePessoa());
        }

        return convertView;
    }

}
